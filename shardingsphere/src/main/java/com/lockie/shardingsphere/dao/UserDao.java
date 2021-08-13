/* Copyright © 2020 pyacm.com and/or its affiliates. All rights reserved. */
package com.lockie.shardingsphere.dao;

import com.lockie.shardingsphere.entity.User;
import io.swagger.models.auth.In;
import java.util.List;

/**
 * @author lvhaoguang
 * @date 2021-08-12 17:28
 */
public interface UserDao {

    String addUser(User user);

    List<User> selectUser();
}
