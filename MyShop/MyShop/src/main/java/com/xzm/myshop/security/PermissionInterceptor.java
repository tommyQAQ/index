package com.xzm.myshop.security;

import com.xzm.myshop.entity.po.Role;
import com.xzm.myshop.repository.RoleMapper;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

//【授权】
// 访问当前路径有哪些角色可以
@Component
public class PermissionInterceptor implements FilterInvocationSecurityMetadataSource {

    //身份持久层对象
    @Resource
    private RoleMapper roleMapper;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        //获取当前访问的url
        String requestURL = ((FilterInvocation)o).getRequestUrl();

        //拿个这个路径，去查询，看当前角色是否拥有这个权限
        List<Role> roleList = this.roleMapper.selectRoleListByOperateUrl(requestURL);

        //判断有权限的角色列表是否是空的
        if(!roleList.isEmpty() && roleList.size()>0){

            //定义String类型数组，存放授权列表
            String[] grantArray = new String[roleList.size()];

            //循环 拥有当前URL访问权限的每一个角色
            for(int i=0; i<roleList.size(); i++){
                grantArray[i] = roleList.get(i).getRole_name();
            }

            //生成返回授权列表
            return SecurityConfig.createList(grantArray);
        }
        else{
            //没有：任何角色都可以访问
            return SecurityConfig.createList("ROLE_LOGIN");
        }
    }



    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        //如果没有授权，提供一个默认的角色
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
