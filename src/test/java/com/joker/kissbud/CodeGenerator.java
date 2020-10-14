package com.joker.kissbud;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String oPath = System.getProperty("user.dir");//得到当前项目的路径
        gc.setOutputDir(oPath + "/src/main/java");   //生成文件输出根目录
        gc.setOpen(false);//生成完成后不弹出文件框
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("Joker");//此处填写代码生成人姓名
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");//数据库用户名
        dsc.setPassword("ktwlrjcs2018");//数据库密码
        dsc.setUrl("jdbc:mysql://139.159.190.0:3306/archive_business_instruction_system_test?useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true&characterEncoding=utf8");//数据库连接地址
        mpg.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] {"account"}); // 需要生成的表
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
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.joker.kissbud");//此处填写包名
        pc.setEntity("entity");
        pc.setMapper("dao");
        pc.setXml("dao.mappers");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        mpg.setPackageInfo(pc);
        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
        // 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        tc.setEntity("templates/generator/entity.java.vm");
        tc.setController("templates/generator/controller.java.vm");
        mpg.setTemplate(tc);
        // 执行生成
        mpg.execute();
    }
}