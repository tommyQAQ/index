package com.xzm.myshop.service.impl;

import com.xzm.myshop.entity.po.Admin;
import com.xzm.myshop.entity.vo.AddAdminVo;
import com.xzm.myshop.entity.vo.AdminRoleVo;
import com.xzm.myshop.entity.vo.AdminVo;
import com.xzm.myshop.repository.AdminMapper;
import com.xzm.myshop.repository.RoleMapper;
import com.xzm.myshop.service.IAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminSevice implements IAdminService {
    //持续层对象
    @Resource
    private AdminMapper adminMapper;

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Integer getAdminCount(String key) {
        return this.adminMapper.selectAdminCount(key);
    }

    @Override
    public List<Admin> getAdminList(String key,Integer start,Integer rows) {
        System.out.println(key+start+rows);
        //可以选择把所有 密码等隐藏信息
        return this.adminMapper.selectAdminList(key,start,rows);
    }

    @Override
    public void removeAdminByAdminId(Integer admin_id) {
        //更新用户状态
        this.adminMapper.deleteAdminByAdminId(admin_id);

        //删除对应记录
        this.roleMapper.deleteRoleByAdminId(admin_id);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)//事务机制
    public void saveAdmin(AddAdminVo addAdminVo) {
        //添加员工
        this.adminMapper.insertAdminByAddAdminVo(addAdminVo);

        //得到员工id
       System.out.println(addAdminVo.getAdmin_id());

        //拿着admin_id和角色身份数组roles去添加参照表admin_role
        //所有数据在Vo中都有 同样是调用一个方法，传入vo
        if (addAdminVo.getRoles()!=null && addAdminVo.getRoles().length>0){
            this.adminMapper.insertAdminRoleByAddAdminVo(addAdminVo);
        }

    }

    @Override
    public AdminVo getAdminVo(Integer admin_id) {
        return this.adminMapper.selectAdminVo(admin_id);
    }

    @Override
    public List<AdminRoleVo> getAdminRoleVo(Integer admin_id) {
        return this.adminMapper.selectAdminRoleVo(admin_id);
    }

    @Override
    public void putAdminByAdminVo(AddAdminVo addAdminVo) {
         //修改员工信息
         this.adminMapper.updateAdminByAdminVo(addAdminVo);

        //更新角色身份对应
        //第一步：把当前所有对应角色身份删除
        this.adminMapper.deleteAdminRoleByAdminId(addAdminVo.getAdmin_id());
        //第二步：按照提交数据逐个添加
        if (addAdminVo.getRoles()!=null && addAdminVo.getRoles().length>0){
            this.adminMapper.insertAdminRoleByAddAdminVo(addAdminVo);
        }
    }
}
