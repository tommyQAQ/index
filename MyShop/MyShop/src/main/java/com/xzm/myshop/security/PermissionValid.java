package com.xzm.myshop.security;


import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

//认证：当前用户是否有访问权限
@Component
public class PermissionValid implements AccessDecisionManager {

    //认证方法

    /**
     * @param authentication 当前登录用户
     * @param o              请求对象
     * @param collection     url对象的角色列表
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        //如果是空的 权限认证失败
        //没有表单提交
        if (authentication==null){
            throw new AccessDeniedException("权限认证失败");
        }


        //迭代遍历 角色列表
        for (ConfigAttribute attr:collection){
            //获取当前授权角色名称
            String grantName = attr.getAttribute();
            //判断是否有默认授权
            if ("ROLE_LOGIN".equals(grantName)){
                //判断用户是否登录
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new BadCredentialsException("请先登录");
                }else {
                    return;//登录了，可以访问公共资源
                }
            }

            //获取 当前用户角色列表
            Collection<? extends GrantedAuthority> roleList = authentication.getAuthorities();

            //迭代遍历 当前用户的角色列表
            for(GrantedAuthority role : roleList){
                //判断 当前提取出的角色 是否就是 授权的角色
                if(grantName.equals(role.getAuthority())){
                    return;
                }
            }
        }

        //当前用户没有访问url权限
        throw new AccessDeniedException("权限认证失败！");

    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
