package com.xzm.myspringboot.service;

import com.xzm.myspringboot.entity.User;

import java.util.List;

//业务逻辑层
public interface IUserService {
    //获取用户列表的业务
    List<User> getUserList();

    User addUser(User user);

    void removeUserByuserId(Integer userId);

    User getUserByuserId(Integer userId);

    void putUserByuserId(User user);
}
