package com.xzm.myspringboot.exception;

public class NoRemoveGenderException extends Exception{

    public NoRemoveGenderException(){
        super("错误编号：35541：禁止性别删除！");
    }
}
