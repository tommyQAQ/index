package com.xzm.myshop.service;

import com.xzm.myshop.entity.po.Admin;
import com.xzm.myshop.entity.vo.AddAdminVo;
import com.xzm.myshop.entity.vo.AdminRoleVo;
import com.xzm.myshop.entity.vo.AdminVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAdminService {
    //搜索员工数据数量-支持key
    Integer getAdminCount(String key);

    //获取员工列表
    List<Admin> getAdminList(String key,Integer start,Integer rows);

    //删除员工信息 通过 员工id
    void removeAdminByAdminId(Integer admin_id);

    //基于Vo对象 实现添加用户
    void saveAdmin(AddAdminVo addAdminVo);

    //按照id查询用户vo对象
    AdminVo getAdminVo(Integer admin_id);

    //按照id查询所有角色身份与当前有员工拥有的角色
    List<AdminRoleVo> getAdminRoleVo(Integer admin_id);

    //按照id更新员工信息
    void putAdminByAdminVo(AddAdminVo addAdminVo);

}
