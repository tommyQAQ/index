package com.xzm.springbootjpa.service.impl;

import com.xzm.springbootjpa.entity.User;
import com.xzm.springbootjpa.repository.UserMapper;
import com.xzm.springbootjpa.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements IUserService {
    //数据持久层
    @Resource
    private UserMapper userMapper;

    @Override
    public void Test() {
        List<User> list=this.userMapper.findAll();
        for (User user:list){
            System.out.println(user.getUserid()+user.getUsername());
        }
    }
}
