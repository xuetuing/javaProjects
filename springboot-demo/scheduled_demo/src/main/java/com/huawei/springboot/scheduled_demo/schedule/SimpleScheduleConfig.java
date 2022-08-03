package com.huawei.springboot.scheduled_demo.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;


public class SimpleScheduleConfig {

    private void configureTask(){
        System.out.println("执行定时任务：" + LocalDateTime.now());
    }
}
