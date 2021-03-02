package com.xzm.springbootjpa.controller;

import com.xzm.springbootjpa.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = {"/user"})
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/index")
    @ResponseBody
    public void index(){
        userService.Test();
    }
}
