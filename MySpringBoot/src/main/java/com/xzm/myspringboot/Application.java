package com.xzm.myspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//当前java类是一个SpringBoot应用程序
@SpringBootApplication
@MapperScan("com.xzm.myspringboot.repository")
public class Application {
    //主函数
    public static void main(String[] args) {
        //调用运行方法(应用程序类, 系统参数)
        SpringApplication.run(Application.class, args);
    }
}