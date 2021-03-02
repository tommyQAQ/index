package com.xzm.myspringboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class GlobarException {
    //@RequestMapping(value = "/show1")
    public String show1(){
        String str = null;
        str.length();
        return "ex/index";
    }
   // @RequestMapping(value = "/show2")
    public String show2(){
        int[] arr =new int[5];
        arr[100] = 5;
        return "ex/index";
    }

    //@ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView ex1(Exception ex){
        ModelAndView mv =new ModelAndView();
        mv.addObject("error",ex.toString());
        mv.setViewName("ex/error");
        return mv;
    }
    //@ExceptionHandler(value = {java.lang.ArrayIndexOutOfBoundsException.class})
    public ModelAndView ex2(Exception ex){
        ModelAndView mv =new ModelAndView();
        mv.addObject("error",ex.toString());
        mv.setViewName("ex/error");
        return mv;
    }
}
