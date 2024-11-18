package com.example.work;

import com.example.work.plan.entity.Plan;
import com.example.work.plan.service.PlanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class WorkApplicationTests {


    @Autowired
    PlanService planService;

    @Test
    void contextLoads() {
//        List<Plan> plans = planMapper.selectList(null);

        Plan plan = new Plan();
        plan.setStatus(1);
        plan.setAreaId(1);
        plan.setPointId(2);
        plan.setTaskName("测试任务");
        plan.setVersion("v1");
        plan.setWorkEfficiency(30);

        plan.setStartTime(LocalDateTime.now());
        plan.setEndTime(LocalDateTime.now().plusDays(30));
        System.out.println();
    }

    @Test
    void list() {
        List<Plan> plans = planService.list();
        System.out.println(plans);
    }


}
