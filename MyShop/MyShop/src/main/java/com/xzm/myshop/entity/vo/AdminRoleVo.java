package com.xzm.myshop.entity.vo;

import org.springframework.stereotype.Component;

//所有身份列表与当前员工拥有的
@Component
public class AdminRoleVo {
    private Integer role_id;
    private String role_name;
    private Integer has;

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

    public Integer getHas() {
        return has;
    }

    public void setHas(Integer has) {
        this.has = has;
    }
}
