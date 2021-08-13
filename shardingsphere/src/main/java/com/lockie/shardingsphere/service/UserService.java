/* Copyright © 2020 pyacm.com and/or its affiliates. All rights reserved. */
package com.lockie.shardingsphere.service;

import com.lockie.shardingsphere.entity.User;
import java.util.List;

/**
 * @author lvhaoguang
 * @date 2021-08-12 17:24
 */
public interface UserService {

    List<User> selectUser();
    
    String addUser(User user);
}
