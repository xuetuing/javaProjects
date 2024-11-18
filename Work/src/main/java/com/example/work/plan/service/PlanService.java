package com.example.work.plan.service;

import com.example.work.plan.entity.Plan;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author DELL
* @description 针对表【plan】的数据库操作Service
* @createDate 2024-11-17 21:35:03
*/
public interface PlanService extends IService<Plan> {

    void batchSave(List<Plan> plans, boolean isDraft);
}
