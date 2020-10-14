package com.joker.kissbud.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;

/**
*
* @Description: account--账号表
* @author Joker
* @date 2020-10-14
*/
@Data
@ApiModel("Account--account--账号")
    public class Account implements Serializable {
    

    private static final long serialVersionUID = 1L;

                
    /**
    * id
    */

            @ApiModelProperty("主键")
                    private Long id;

        
    /**
    * user_name
    */

            @ApiModelProperty("用户账号(不可重复)")
                    private String userName;

        
    /**
    * real_name
    */

            @ApiModelProperty("真实姓名")
                    private String realName;

        
    /**
    * tele_num
    */

            @ApiModelProperty("手机号码(不可重复)")
                    private String teleNum;

        
    /**
    * sex
    */

            @ApiModelProperty("性别(1为男性，0为女性)")
                    private Boolean sex;

        
    /**
    * email
    */

            @ApiModelProperty("邮箱(不可重复)")
                    private String email;

        
    /**
    * role_id
    */

            @ApiModelProperty("角色Id")
                    private Long roleId;

        
    /**
    * role_name
    */

            @ApiModelProperty("角色名称")
                    private String roleName;

        
    /**
    * department_id
    */

            @ApiModelProperty("部门id")
                    private Long departmentId;

        
    /**
    * department_name
    */

            @ApiModelProperty("部门名称")
                    private String departmentName;

        
    /**
    * enable
    */

            @ApiModelProperty("账号状态(1启用，0禁用)")
                    private Boolean enable;

        
    /**
    * identity_type
    */

            @ApiModelProperty("证件类型(IDCARD:身份证)")
                    private String identityType;

        
    /**
    * identity_num
    */

            @ApiModelProperty("证件号码")
                    private String identityNum;

        
    /**
    * remark
    */

            @ApiModelProperty("备注")
                    private String remark;

        
    /**
    * password
    */

            @ApiModelProperty("密码")
                    private String password;

        
    /**
    * profile
    */

            @ApiModelProperty("头像")
                    private String profile;

        
    /**
    * creator
    */

            @ApiModelProperty("创建人")
                    private String creator;

        
    /**
    * creator_id
    */

            @ApiModelProperty("创建人id")
                    private Long creatorId;

        
    /**
    * created_at
    */

            @ApiModelProperty("创建时间")
                    private LocalDateTime createdAt;

        
    /**
    * update_at
    */

            @ApiModelProperty("更新时间")
                    private LocalDateTime updateAt;

        
    /**
    * password_strength
    */

            @ApiModelProperty("密码强度(0:弱,1:中,2:强)")
                    private Integer passwordStrength;

        
    /**
    * introduce
    */

            @ApiModelProperty("个人介绍")
                    private String introduce;

    

    
    
    
    }