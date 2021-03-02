package com.xzm.myshop.repository;

import com.xzm.myshop.entity.po.Admin;
import com.xzm.myshop.entity.vo.AddAdminVo;
import com.xzm.myshop.entity.vo.AdminRoleVo;
import com.xzm.myshop.entity.vo.AdminVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    //提供按照用户名获取用户对象的方法
    //提供给AdminDetailService使用
    Admin getAdminByAdminName(@Param("admin_name") String S);

    //查询所有员工列表
    List<Admin> selectAdminList(
            @Param("key")String key,
            @Param("start")Integer start,
            @Param("rows")Integer rows);


    //查询员工总信息数据行数
    Integer selectAdminCount(@Param("key")String key);

    //根据id删除员工（实际并不是删除员工，而是改变员工状态)
    void deleteAdminByAdminId(@Param("admin_id") Integer admin_id);

    //按照Vo对象添加员工
    void insertAdminByAddAdminVo(@Param("addAdminVo")AddAdminVo addAdminVo);

    //按照Vo 添加员工与身份参照
    void insertAdminRoleByAddAdminVo(@Param("addAdminVo")AddAdminVo addAdminVo);

    //按照id查询，返回vo对象
    AdminVo selectAdminVo(@Param("admin_id")Integer admin_id);

    //按照id查询，返回身份vo对象
    List<AdminRoleVo> selectAdminRoleVo(@Param("admin_id")Integer id);

    //按照vo对象更新员工信息
    void updateAdminByAdminVo(@Param("addAdminVo")AddAdminVo addAdminVo);

    //按照admin_id删除所有身份角色
    void deleteAdminRoleByAdminId(@Param("admin_id")Integer admin_id);
}
