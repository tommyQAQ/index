package com.xzm.myspringboot.service.impl;

import com.xzm.myspringboot.entity.User;
import com.xzm.myspringboot.repository.UserMapper;
import com.xzm.myspringboot.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

//具体业务实现类
@Service
public class UserService implements IUserService {
    //数据持久层
    @Resource
    private UserMapper userMapper;

    //获取用户列表的业务
    @Override
    public List<User> getUserList() {
        //直接调用，过度数据
        return this.userMapper.selectUserList();
    }

    @Override
    public User addUser(User user) {
        return this.userMapper.insertUser(user);
    }

    @Override
    public void removeUserByuserId(Integer userId) {
        this.userMapper.deleteUserByuserId(userId);
    }

    @Override
    public User getUserByuserId(Integer userId) {
        return this.userMapper.selectUserByuserId(userId);
    }

    @Override
    public void putUserByuserId(User user) {
        this.userMapper.updateUserByuserId(user);
    }
}
