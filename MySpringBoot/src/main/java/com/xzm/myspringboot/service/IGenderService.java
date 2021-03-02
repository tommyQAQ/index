package com.xzm.myspringboot.service;


import com.xzm.myspringboot.exception.NoRemoveGenderException;

public interface IGenderService {
    //按照id删除性别
    void removeGenderBygenderId(Integer genderId)throws NoRemoveGenderException;
}
