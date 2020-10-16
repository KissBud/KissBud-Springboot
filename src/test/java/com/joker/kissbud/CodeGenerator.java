package com.joker.kissbud;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//得到当前项目的路径
        gc.setOutputDir(projectPath + "/src/main/java");   //生成文件输出根目录
        gc.setOpen(false);//生成完成后不弹出文件框
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("Joker");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        gc.setSwagger2(true);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");//数据库用户名
        dsc.setPassword("123456");//数据库密码
        dsc.setUrl("jdbc:mysql://localhost:3306/kissbud?useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true&characterEncoding=utf8");//数据库连接地址

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.joker.kissbud");//此处填写包名

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        String mapperPath= "templates/generator/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(mapperPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mappers/" + pc.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);

        // 模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
        // 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        tc.setController("templates/generator/controller.java.vm");
        tc.setXml(null);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
//        strategy.setInclude(new String[] {"account"}); // 需要生成的表
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        //strategy.setTablePrefix(new String[] { "t_" });// 此处可以修改为您的表前缀
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.mayi.test.base.BaseEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] {});
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceImplClass("com.mayi.test.base.BaseService");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.mayi.test.base.BaseController");
        // 逻辑删除属性名称
        // strategy.setLogicDeleteFieldName("is_deleted");
        // List<TableFill> tableFillList= CollUtil.newArrayList();
        // TableFill fill=new TableFill("update_time", FieldFill.INSERT_UPDATE);
        // tableFillList.add(fill);
        // fill=new TableFill("create_time", FieldFill.INSERT);
        // tableFillList.add(fill);
        // strategy.setTableFillList(tableFillList);

        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dsc);
        mpg.setStrategy(strategy);
        mpg.setTemplate(tc);
        mpg.setPackageInfo(pc);
        mpg.setCfg(cfg);
        // 执行生成
        mpg.execute();
    }
}