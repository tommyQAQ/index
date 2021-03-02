package com.xzm.myshop.entity.po;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class Admin implements UserDetails {
    private Integer admin_id;
    private String admin_name;
    private String admin_pass;
    private String admin_nickname;
    private Integer admin_status;

    //角色对象列表，给Security使用
    private List<Role> roleList=new ArrayList<Role>();

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_pass() {
        return admin_pass;
    }

    public void setAdmin_pass(String admin_pass) {
        this.admin_pass = admin_pass;
    }

    public String getAdmin_nickname() {
        return admin_nickname;
    }

    public void setAdmin_nickname(String admin_nickname) {
        this.admin_nickname = admin_nickname;
    }

    public Integer getAdmin_status() {
        return admin_status;
    }

    public void setAdmin_status(Integer admin_status) {
        this.admin_status = admin_status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoleList();
    }

    @Override
    public String getPassword() {
        return this.getAdmin_pass();
    }

    @Override
    public String getUsername() {
        return this.getAdmin_name();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
