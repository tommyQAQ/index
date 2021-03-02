package com.xzm.myspringboot.service.impl;
import com.xzm.myspringboot.entity.User;
import com.xzm.myspringboot.exception.NoRemoveGenderException;
import com.xzm.myspringboot.repository.GenderMapper;
import com.xzm.myspringboot.repository.UserMapper;
import com.xzm.myspringboot.service.IGenderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GenderService implements IGenderService {
    //数据持久层
    @Resource
    private GenderMapper genderMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeGenderBygenderId(Integer genderId) throws NoRemoveGenderException{
        this.genderMapper.deleteGenderBygenderId(genderId);
        List<User> list=this.userMapper.selectUserBygenderId(genderId);
        if (list!=null && list.size()>0){
            throw new NoRemoveGenderException();
        }
    }
}
