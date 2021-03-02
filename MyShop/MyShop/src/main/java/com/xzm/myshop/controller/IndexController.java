package com.xzm.myshop.controller;

import com.xzm.myshop.entity.po.Admin;
import com.xzm.myshop.entity.po.Menu;
import com.xzm.myshop.entity.po.Role;
import com.xzm.myshop.entity.vo.AdminInfoVo;
import com.xzm.myshop.entity.vo.MenuVO;
import com.xzm.myshop.service.IIndexService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//主界面控制器
@Controller
@RequestMapping(value={"/","/index"})
public class IndexController {

    //业务逻辑对象
    @Resource
    private IIndexService indexService;

    //主界面
    @RequestMapping(value={"/","/index"})
    public String index(Authentication authentication, HttpSession session){

        //获取当前登录用户的信息，
        //打开页面之前，已经Security已经执行过了
        //它里面有一个对象Authentication authentication，
        //就是当前登录用户，只有两个方法，用户名和密码
        String username = authentication.getName();

        //按照这个username信息查询出它的权限所对应的所有菜单
        List<Menu> menuList = this.indexService.getMenuListByAdminName(username);

        //通过代码，组合自己需要的VO对象
        //第一步：创建vo对象的集合
        List<MenuVO> menuVOList = new ArrayList<MenuVO>();

        //第二步：循环得到的结果集，判断，创建一级菜单对象放入
        for(Menu m : menuList){
            if(m.getPid()==null){
                MenuVO menuVo = new MenuVO();
                menuVo.setMenu(m);
                menuVOList.add(menuVo);
            }
        }

        //循环遍历刚才vo大集合，为每一个一级菜单放入二级菜单
        for(MenuVO mv : menuVOList){
            //一级菜单的id
            Integer menu_id = mv.getMenu().getMenu_id();

            //循环查询出来的菜单集合
            for(Menu m : menuList){
                if(m.getPid()==menu_id){
                    mv.getMenus().add(m);
                }
            }
        }

        //菜单放到 session中，这样每一个控制器都可以使用了
        session.setAttribute("menuvo",menuVOList);

        //按照名称获取管理与信息
        Admin admin = this.indexService.getAdminByAdminName(username);

        session.setAttribute("nickname",admin.getAdmin_nickname());

        //组合信息vo对象
        AdminInfoVo adminInfoVo = new AdminInfoVo();

        //设置数据
        adminInfoVo.setAdmin_nickname(admin.getAdmin_nickname());
        for (Role role:admin.getRoleList()){
            //在vo对象中，获取列表集合，然后添加
            adminInfoVo.getRoles().add(role.getRole_name());
        }



        //把组合vo对象放入session
        session.setAttribute("admin",adminInfoVo);


        return "index/index";
    }

}
