package com.xzm.springbootjpa;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration
public class ApplicationTest {
    //主要两个方法，可以执行AOP
    //测试开始
    @Before
    public void before(){
        System.out.println("--- Test-Start ---");
    }


    //测试结束
    @After
    public  void after(){
        System.out.println("--- Test-End ---");
    }

}
