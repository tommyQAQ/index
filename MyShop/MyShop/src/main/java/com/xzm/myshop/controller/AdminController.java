package com.xzm.myshop.controller;

import com.xzm.myshop.entity.po.Admin;
import com.xzm.myshop.entity.po.Role;
import com.xzm.myshop.entity.vo.AddAdminVo;
import com.xzm.myshop.entity.vo.AdminRoleVo;
import com.xzm.myshop.entity.vo.AdminVo;
import com.xzm.myshop.exception.AddAdminException;
import com.xzm.myshop.service.IAdminService;
import com.xzm.myshop.service.IRoleService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    //业务逻辑对象
    @Resource
    private IAdminService iAdminService;

    //身份业务逻辑对象
    @Resource
    private IRoleService iRoleService;

    //登录页面
    @RequestMapping("/login")
    public String login(Model model){
        //自定义添加功能代码
        model.addAttribute("news","近期疫情反弹，同事们注意保护自己！");
        return "admin/login";
    }



    //登录提交方法
    //对应表单控件name，接收用户名和密码
    //返回null就可以了，会被Security拦截掉的
    @RequestMapping("/dologin")
    public String dologin(String username, String password){
        return null;
    }

    //===========================================

    //员工管理:关键字key 页数page
    @RequestMapping("/admin")
    public String admin(String key,Integer page,Model model){
        //页数
        if (page==null || page<1){
            page=1;//默认第一页
        }
        //带入搜索关键字 查询有多少数据
        int count= this.iAdminService.getAdminCount(key);



        //计算总页数：每页3条
        int allpage=count/3;
        if(count%3>0){
            allpage++;
        }

        //追加一个判断，allpage必须大于1
        //否则如果page是1的话，可能会导致页数在后面计算，变成0，结果就是-3了
        if (allpage>1 && page>allpage){//超出最后一页就显示最后一页
            page=allpage;
        }

        //页数加入模型
        model.addAttribute("page",page);
        model.addAttribute("allpage",allpage);

        //计算开始行数
        int start=(page-1)*3;

        //每页条数
        int rows=3;

        //获取所有员工信息对象的列表
        List<Admin> adminList =this.iAdminService.getAdminList(key,start,rows);

        System.out.println("adminList----"+adminList.size());

        //放入模型中交给视图层显示
        model.addAttribute("adminList",adminList);
        model.addAttribute("key",key);

        return "admin/admin";
    }

    //删除员工
    @RequestMapping("/delete")
    public String delete(Integer id){
        this.iAdminService.removeAdminByAdminId(id);
        //跳回路劲
        return "redirect:/admin/admin";
    }

    //添加员工
    @RequestMapping("/add")
    public String add(Model model){

        //获取所有身份列表
        List<Role> roleList=this.iRoleService.getRoleList();

        model.addAttribute(roleList);
        return "admin/add";
    }

    //添加员工执行：获取表单提交自动封装成的Vo对象
    @RequestMapping("/save")
    public String save(AddAdminVo addAdminVo){
        //密码加密
        //拿出原始内容
        String pass= addAdminVo.getAdmin_pass();

        //加密
        pass= new BCryptPasswordEncoder().encode(pass);
        System.out.println(pass);

        //放回
        addAdminVo.setAdmin_pass(pass);

        //添加
        this.iAdminService.saveAdmin(addAdminVo);

        //路径重定向跳转
        return "redirect:/admin/admin";
    }

    //修改员工权限
    @RequestMapping("/update")
    public String update(Integer id,Model model){
        //获取部分角色信息同时需要所有的角色列表以及当前用户拥有哪些角色
        //vo配vo
        //AdminRoleVo = 自己选择的语句，包含一个是否选中的列
        //UpdateRoleVo = 包含必要的属性和AdminRoleVo

        //第一步：调用业务，传入指定id，还需要返回vo
        AdminVo adminVo = this.iAdminService.getAdminVo(id);

        //第二步：调用业务，传入指定id，还需要返回所有角色与拥有角色的vo
        adminVo.setAdminRoleVoList(this.iAdminService.getAdminRoleVo(id));

        System.out.println(adminVo.getAdmin_name());

        //加入模型
        model.addAttribute("adminVo",adminVo);

        return  "admin/update";
    }
    //更新员工信息
    //表单提交信息与添加一致，多了一个员工id
    @RequestMapping("/alter")
    public String alter(AddAdminVo addAdminVo){
        //密码加密
        if (addAdminVo.getAdmin_pass()!=null && addAdminVo.getAdmin_pass()!=""){
            //拿出原始内容
            String pass= addAdminVo.getAdmin_pass();

            //加密
            pass= new BCryptPasswordEncoder().encode(pass);
            System.out.println(pass);

            //放回
            addAdminVo.setAdmin_pass(pass);
        }



        //按照admin_id更新用户信息
        this.iAdminService.putAdminByAdminVo(addAdminVo);
         System.out.println(addAdminVo.getAdmin_id());

        //更新角色身份对应
        //第一步：把当前所有对应角色身份删除

        //第二步：按照提交数据逐个添加


        //路径重新定向跳转
        //return "redirect:/admin/update?id="+addAdminVo.getAdmin_id();

        return "redirect:/admin/admin";
    }
}
