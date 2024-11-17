package com.example.work.generator.service;

import com.example.work.generator.entity.Plan;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author DELL
* @description 针对表【plan】的数据库操作Service
* @createDate 2024-11-17 12:01:10
*/
public interface PlanService extends IService<Plan> {
    int insert(Plan plan);
}
