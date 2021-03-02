package com.xzm.myshop.repository;

import com.xzm.myshop.entity.po.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    //按照用户名查到用户拥有权限的所有菜单
    List<Menu> selectMenuListByAdminName(@Param("admin_name") String admin_name);
}
