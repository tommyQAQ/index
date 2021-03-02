package com.xzm.myshop.entity.vo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminVo {
    private Integer admin_id;
    private String admin_name;
    private String admin_nickname;
    private List<AdminRoleVo> adminRoleVoList;

    public List<AdminRoleVo> getAdminRoleVoList() {
        return adminRoleVoList;
    }

    public void setAdminRoleVoList(List<AdminRoleVo> adminRoleVoList) {
        this.adminRoleVoList = adminRoleVoList;
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

    public String getAdmin_nickname() {
        return admin_nickname;
    }

    public void setAdmin_nickname(String admin_nickname) {
        this.admin_nickname = admin_nickname;
    }
}
