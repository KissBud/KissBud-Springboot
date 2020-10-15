package com.joker.kissbud.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.joker.kissbud.entity.Account;
import com.joker.kissbud.service.impl.AccountServiceImpl;


/**
 * @author Joker
 * @version 1.0
 * @date 2020-10-15
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
     * @return ResponseEntity<?>
     */
    @ApiOperation(value = "account--账号新增", httpMethod = "POST", produces = "application/json", response = ResponseEntity.class)
    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Account request){
        return ResponseEntity.ok(accountService.save(request));
    }

    /**
     * account--账号修改
     *
     * @param request
     * @return ResponseEntity<?>
     */
    @ApiOperation(value = "account--账号修改", httpMethod = "POST", produces = "application/json", response = ResponseEntity.class)
    @ResponseBody
    @PostMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody Account request){
        return ResponseEntity.ok(accountService.saveOrUpdate(request));
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
    public ResponseEntity<?> delete(@ApiParam(name = "id", value = "Accountid") @RequestParam(defaultValue = "", required = false) Long id) {
        return ResponseEntity.ok(accountService.removeById(id));
    }


    /**
     * 所有account--账号
    *
     * @return ResponseEntity<?>
    */
    @ApiOperation(value = "所有account--账号")
    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(accountService.list());
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
    @RequestParam(defaultValue = "", required = true) Long id){
        return ResponseEntity.ok(accountService.getById(id));
    }
}
