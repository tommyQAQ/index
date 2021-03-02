package com.xzm.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/","/index"})
public class IndexController {
    @RequestMapping(value = {"/","/index"})
    @ResponseBody
    public String index(){
        return "我的第一个界面";
    }
}
