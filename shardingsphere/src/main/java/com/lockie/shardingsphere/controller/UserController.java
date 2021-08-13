package com.lockie.shardingsphere.controller;

import com.lockie.shardingsphere.entity.User;
import com.lockie.shardingsphere.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Created by lvhaoguang
 * @Time: 2020/2/8 10:40
 */
@Api(tags = {"测试"},description = "测试列表")
@RestController
@RequestMapping("/shardingsphere")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/select")
    @ApiOperation(value = "查询用户")
    public List<User> select(){
        return userService.selectUser();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加用户")
    public String add(@RequestBody User user){
        return userService.addUser(user);
    }
}

