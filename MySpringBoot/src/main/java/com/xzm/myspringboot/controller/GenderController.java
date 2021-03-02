package com.xzm.myspringboot.controller;

import com.xzm.myspringboot.exception.NoRemoveGenderException;
import com.xzm.myspringboot.service.IGenderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("gender")
public class GenderController {
    //业务逻辑对象
    private IGenderService genderService;

    @RequestMapping("/delete")
    public String delete(Integer genderId) throws NoRemoveGenderException {
        //判断是否有提交
        if (genderId!=null){
            this.genderService.removeGenderBygenderId(genderId);
            System.out.print("删除成功");
        }
        return "gender/delete";
    }
}
