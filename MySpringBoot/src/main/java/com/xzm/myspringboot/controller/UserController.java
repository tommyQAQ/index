package com.xzm.myspringboot.controller;

import com.xzm.myspringboot.entity.User;
import com.xzm.myspringboot.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

//用户控制器
@Controller
@RequestMapping("/user")
public class UserController {
    //业务逻辑对象
    @Resource
    private IUserService userService;

    //用户列表主界面
    @RequestMapping(value = {"/","/index"})
    public String index(Model model){
        //调用业务功能，得到用户列表
        List<User> list =this.userService.getUserList();

        //把list当做数据传入视图中；交给视图解析器处理
        model.addAttribute("list",list);

        return "user/index";
    }
    @RequestMapping("/add")
    public String add(User user,Model model) {
        String msg = "";
        if (user.getUserName()!=null){
           user = this.userService.addUser(user);
           if (user.getUserId()!=null){
             msg="注册成功";
           }
        }else {
            msg="注册失败";
        }
        model.addAttribute("message",msg);
        return "user/add";
    }
    @RequestMapping(value = {"/delete/{userId}"})
    public String delete(@PathVariable Integer userId){
        this.userService.removeUserByuserId(userId);
        return "user/delete";
    }

    @RequestMapping(value = {"/update/{userId}"})
    public String update(@PathVariable Integer userId,Model model,User user){
        if (user.getUserName()!=null){
            user.setUserId(userId);

            this.userService.putUserByuserId(user);
        }

        user = this.userService.getUserByuserId(userId);

        model.addAttribute("user",user);
        return "user/update";
    }

}
