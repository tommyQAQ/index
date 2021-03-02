package com.xzm.myshop.repository;

import com.xzm.myshop.entity.po.Role;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import java.util.List;

//角色接口
@Repository
public interface RoleMapper {

    //按照员工id查询角色列表
    //提供给Admin数据持久层使用
    List<Role> selectRoleListByAdminId(@Param("admin_id") Integer admin_id);

    //按照一个路径 查询角色列表
    List<Role> selectRoleListByOperateUrl(@Param("operate_url") String operate_url);

    //根据员工id删除其所有身份
    void deleteRoleByAdminId(@Param("admin_id") Integer admin_id);

    //获取所有身份信息
    List<Role> selectRoleList();

}
