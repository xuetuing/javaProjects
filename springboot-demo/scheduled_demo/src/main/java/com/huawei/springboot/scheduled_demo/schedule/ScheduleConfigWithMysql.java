package com.huawei.springboot.scheduled_demo.schedule;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class ScheduleConfigWithMysql implements SchedulingConfigurer {
    @Mapper
    public interface CronMapper{
        @Select("select cron from cron limit 1")
        String getCron();
    }
    @Autowired
    @SuppressWarnings("all")
    CronMapper cronMapper;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                // 添加任务内容(Runnable)
                () -> System.out.println("执行定时任务：" + LocalDateTime.now().toLocalTime()),
                //设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronMapper.getCron();
                    //2.2 合法性校验
                    if(StringUtils.isEmpty(cron)){
                        System.out.println("the cron is empty.");
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }


        );
    }
}
