/* Copyright © 2020 pyacm.com and/or its affiliates. All rights reserved. */
package com.lockie.shardingsphere.service.impl;

import com.lockie.shardingsphere.dao.UserDao;
import com.lockie.shardingsphere.entity.User;
import com.lockie.shardingsphere.service.UserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author lvhaoguang
 * @date 2021-08-12 17:25
 */
@Slf4j
@Validated
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectUser() {
        return userDao.selectUser();
    }

    @Override
    public String addUser(User user) {
        return userDao.addUser(user);
    }
}

