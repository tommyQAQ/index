package com.xzm.myshop.entity.po;

import org.springframework.security.core.GrantedAuthority;
//介入GrantedAuthority是为了做到统一操作，实现方法，获取角色列表
public class Role implements GrantedAuthority {
    //角色属性
    private Integer role_id;
    private String role_name;

    //属性封装
    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    //返回获取当前授权的角色名字
    @Override
    public String getAuthority() {
        return this.getRole_name();
    }
}
