package com.xzm.myshop.service;


import com.xzm.myshop.entity.po.Admin;
import com.xzm.myshop.repository.AdminMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminDetailService implements UserDetailsService {
    @Resource
    private AdminMapper adminMapper;

    //String s 就是拦截得到的用户名 对应name="username"
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //按照截取的用户名，通过Repository找到对应的用户名称
        Admin admin = this.adminMapper.getAdminByAdminName(s);


        //判断是否找到这个用户
        if (admin==null){
            //没有就抛出异常
            throw new UsernameNotFoundException("查找的账户不存在！");
        }
        //有用户 就返回用户
        return admin;
    }
}
