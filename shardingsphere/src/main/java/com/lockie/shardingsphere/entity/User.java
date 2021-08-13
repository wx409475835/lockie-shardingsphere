/* Copyright © 2020 pyacm.com and/or its affiliates. All rights reserved. */
package com.lockie.shardingsphere.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @author lvhaoguang
 * @date 2021-08-12 17:25
 */
@Data
public class User {
    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("出生年月")
    private Date birthday;
}
