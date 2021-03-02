package com.xzm.springbootjpa.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Demo {
    @Scheduled(cron="")
    public void ScheduledMethod(){
        System.out.println("定时任务执行了");
    }

}
