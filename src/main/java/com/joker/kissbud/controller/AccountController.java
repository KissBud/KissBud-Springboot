package com.joker.kissbud.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.joker.kissbud.entity.Account;
import com.joker.kissbud.service.impl.AccountServiceImpl;


/**
 * @author Joker
 * @version 1.0
 * @date 2020-10-14
 */
@Api(value = "account--账号管理")
@RestController
@RequestMapping("/")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;


    /**
     * account--账号新增
     *
     * @param request
     * @param bindingResult
     * @return ResponseEntity<?>
     */
    @ApiOperation(value = "account--账号新增", httpMethod = "POST", produces = "application/json", response = ResponseEntity.class)
    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Account request, BindingResult bindingResult) throws UnsupportedEncodingException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.ok(Result.body(request, ResultType.CHECK_ERROR).withMessage(bindingResult.getFieldError().getDefaultMessage()));
        }
        Result result = accountService.save(request);
        return ResponseEntity.ok(result);
    }

    /**
     * account--账号修改
     *
     * @param request
     * @param bindingResult
     * @return ResponseEntity<?>
     */
    @ApiOperation(value = "account--账号修改", httpMethod = "POST", produces = "application/json", response = ResponseEntity.class)
    @ResponseBody
    @PostMapping("/edit")
    public ResponseEntity<?> edit(@Valid @RequestBody Account request, BindingResult bindingResult) throws UnsupportedEncodingException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.ok(Result.body(request, ResultType.CHECK_ERROR).withMessage(bindingResult.getFieldError().getDefaultMessage()));
        }
        Result result = accountService.edit(request);
        return ResponseEntity.ok(result);
    }

    /**
     * account--账号删除
     *
     * @param id id
     * @return ResponseEntity<?>
     */
    @ApiOperation(value = "account--账号删除", httpMethod = "GET", produces = "application/json", response = ResponseEntity.class)
    @ResponseBody
    @GetMapping("/delete")
    public ResponseEntity<?> delete(@ApiParam(name = "id", value = "TableInfo(importPackages=[java.time.LocalDateTime, java.io.Serializable], convert=false, name=account, comment=account--账号, entityName=Account, mapperName=AccountMapper, xmlName=AccountMapper, serviceName=AccountService, serviceImplName=AccountServiceImpl, controllerName=AccountController, fields=[TableField(convert=false, keyFlag=true, keyIdentityFlag=false, name=id, type=bigint(30), propertyName=id, columnType=LONG, comment=主键, fill=null, keyWords=false, columnName=id, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=user_name, type=varchar(30), propertyName=userName, columnType=STRING, comment=用户账号(不可重复), fill=null, keyWords=false, columnName=user_name, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=real_name, type=varchar(30), propertyName=realName, columnType=STRING, comment=真实姓名, fill=null, keyWords=false, columnName=real_name, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=tele_num, type=varchar(30), propertyName=teleNum, columnType=STRING, comment=手机号码(不可重复), fill=null, keyWords=false, columnName=tele_num, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=sex, type=bit(1), propertyName=sex, columnType=BOOLEAN, comment=性别(1为男性，0为女性), fill=null, keyWords=false, columnName=sex, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=email, type=varchar(50), propertyName=email, columnType=STRING, comment=邮箱(不可重复), fill=null, keyWords=false, columnName=email, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=role_id, type=bigint(30), propertyName=roleId, columnType=LONG, comment=角色Id, fill=null, keyWords=false, columnName=role_id, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=role_name, type=varchar(30), propertyName=roleName, columnType=STRING, comment=角色名称, fill=null, keyWords=false, columnName=role_name, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=department_id, type=bigint(30), propertyName=departmentId, columnType=LONG, comment=部门id, fill=null, keyWords=false, columnName=department_id, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=department_name, type=varchar(30), propertyName=departmentName, columnType=STRING, comment=部门名称, fill=null, keyWords=false, columnName=department_name, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=enable, type=bit(1), propertyName=enable, columnType=BOOLEAN, comment=账号状态(1启用，0禁用), fill=null, keyWords=false, columnName=enable, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=identity_type, type=varchar(30), propertyName=identityType, columnType=STRING, comment=证件类型(IDCARD:身份证), fill=null, keyWords=false, columnName=identity_type, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=identity_num, type=varchar(50), propertyName=identityNum, columnType=STRING, comment=证件号码, fill=null, keyWords=false, columnName=identity_num, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=remark, type=varchar(100), propertyName=remark, columnType=STRING, comment=备注, fill=null, keyWords=false, columnName=remark, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=password, type=varchar(200), propertyName=password, columnType=STRING, comment=密码, fill=null, keyWords=false, columnName=password, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=profile, type=varchar(100), propertyName=profile, columnType=STRING, comment=头像, fill=null, keyWords=false, columnName=profile, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=creator, type=varchar(30), propertyName=creator, columnType=STRING, comment=创建人, fill=null, keyWords=false, columnName=creator, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=creator_id, type=bigint(30), propertyName=creatorId, columnType=LONG, comment=创建人id, fill=null, keyWords=false, columnName=creator_id, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=created_at, type=datetime, propertyName=createdAt, columnType=LOCAL_DATE_TIME, comment=创建时间, fill=null, keyWords=false, columnName=created_at, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=update_at, type=datetime, propertyName=updateAt, columnType=LOCAL_DATE_TIME, comment=更新时间, fill=null, keyWords=false, columnName=update_at, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=password_strength, type=tinyint(4), propertyName=passwordStrength, columnType=INTEGER, comment=密码强度(0:弱,1:中,2:强), fill=null, keyWords=false, columnName=password_strength, customMap=null), TableField(convert=false, keyFlag=false, keyIdentityFlag=false, name=introduce, type=varchar(300), propertyName=introduce, columnType=STRING, comment=个人介绍, fill=null, keyWords=false, columnName=introduce, customMap=null)], havePrimaryKey=true, commonFields=[], fieldNames=id, user_name, real_name, tele_num, sex, email, role_id, role_name, department_id, department_name, enable, identity_type, identity_num, remark, password, profile, creator, creator_id, created_at, update_at, password_strength, introduce)id") @RequestParam(defaultValue = "", required = false) Long id) {
        Result result = accountService.deleteById(id);
        return ResponseEntity.ok(result);
    }


    /**
     * account--账号分页
    *
     * @return ResponseEntity<?>
    */
    @ApiOperation(value = "account--账号分页")
    @GetMapping("/list")
    public ResponseEntity<?> list(InstructionPageRequest request) {
        Result result = instructionService.findPage(request);
        return ResponseEntity.ok(result);
        }

    /**
    * account--账号详情
    *
    * @return ResponseEntity<?>
    */
    @ApiOperation(value = "account--账号详情", httpMethod = "GET", produces = "application/json", response = ResponseEntity.class)
    @ResponseBody
    @GetMapping("/getById")
    public ResponseEntity<?> getById(
    @RequestParam(defaultValue = "", required = true) Long id) throws UnsupportedEncodingException {
        Result result = instructionService.getById(id);
        return ResponseEntity.ok(result);
    }
}
