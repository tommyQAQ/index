package com.xzm.myspringboot.controller;

import com.xzm.myspringboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = {"/","/index"})
public class IndexController {
    @RequestMapping(value = {"/","/index"})
    public String index(Model model){
        model.addAttribute("title","<a href='#'>美国大选</a>");

        model.addAttribute("name","张三");

        model.addAttribute("gender",1);

        User user= new User();

        user.setUserId(555);
        user.setUserName("admin");
        user.setUserPass("123456");
        model.addAttribute("user",user);

        List<User> list = new ArrayList<User>();
        for(int i=1;i<=5;i++){
            User user1=new User();
            user1.setUserId(i);
            user1.setUserName("用户"+i);
            user1.setUserPass("123456"+i);
        }
        model.addAttribute("list",list);

        model.addAttribute("image","aaa.jpg");
        //返回视图文件 视图文件在resources/templates/index/index.html
        return "index/index";
    }
    @RequestMapping(value= {"/getpost"})
    @ResponseBody
    public String getpost(User user){
            return user.getUserName();
    }
    @RequestMapping(value= {"/geturl/{userId}/{userName}"})
    @ResponseBody
    public String geturl(@PathVariable Integer userId,@PathVariable String userName){
        return userId+userName;
    }
}
