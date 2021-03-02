package com.xzm.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//当前java类是一个SpringBoot应用程序
@SpringBootApplication
public class Application {
    //主函数
    public static void main(String[] args) {
        //调用运行方法(应用程序类, 系统参数)
        SpringApplication.run(Application.class, args);
    }
}
