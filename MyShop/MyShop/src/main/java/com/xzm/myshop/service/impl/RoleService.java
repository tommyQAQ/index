package com.xzm.myshop.service.impl;

import com.xzm.myshop.entity.po.Role;
import com.xzm.myshop.repository.RoleMapper;
import com.xzm.myshop.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoleList() {
        return this.roleMapper.selectRoleList();
    }
}
