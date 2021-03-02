package com.xzm.myshop.service.impl;

import com.xzm.myshop.entity.po.Admin;
import com.xzm.myshop.entity.po.Menu;
import com.xzm.myshop.repository.AdminMapper;
import com.xzm.myshop.repository.MenuMapper;
import com.xzm.myshop.service.IIndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IndexService implements IIndexService {
    //数据持久层对象
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private MenuMapper menuMapper;

    //按照用户名获取权限菜单的业务
    @Override
    public List<Menu> getMenuListByAdminName(String admin_name) {
        //调用方法 数据过度
        return this.menuMapper.selectMenuListByAdminName(admin_name);
    }

    @Override
    public Admin getAdminByAdminName(String admin_name) {
        return this.adminMapper.getAdminByAdminName(admin_name);
    }
}
