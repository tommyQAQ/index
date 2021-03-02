package com.xzm.myspringboot.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class ExceptionConfiguration implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o,
                                         Exception e) {
        ModelAndView mv= new ModelAndView();
        if (e instanceof java.lang.NullPointerException){
            mv.setViewName("ex/error");
        }
        if (e instanceof java.lang.ArrayIndexOutOfBoundsException){
            mv.setViewName("ex/error");
        }

        if (e instanceof SpelEvaluationException){
            mv.setViewName("ex/error");
        }
        if (e instanceof NoRemoveGenderException){
            mv.addObject("err",e.toString());
            mv.setViewName("ex/error");
        }
        return mv;
    }
}
