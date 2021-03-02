package com.xzm.springbootjpa.repository;

import com.xzm.springbootjpa.Application;
import com.xzm.springbootjpa.ApplicationTest;
import com.xzm.springbootjpa.entity.User;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;


public class UserMapperTest extends ApplicationTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void test_findAll(){
        List<User> list=this.userMapper.findAll();
        for (User user:list) {
            System.out.println(user.getUserid() + user.getUsername());
        }
    }

}
