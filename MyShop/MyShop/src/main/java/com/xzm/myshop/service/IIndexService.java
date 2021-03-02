package com.xzm.myshop.service;

import com.xzm.myshop.entity.po.Admin;
import com.xzm.myshop.entity.po.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

//index业务逻辑
@Service
public interface IIndexService {
    //获取菜单的业务逻辑
    List<Menu> getMenuListByAdminName(String admin_name);

    //按照用户名获取用户信息对象
    Admin getAdminByAdminName(String admin_name);


}
