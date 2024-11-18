package com.example.work.plan.service;

import com.example.work.plan.entity.PlanVersion;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author DELL
* @description 针对表【plan_version】的数据库操作Service
* @createDate 2024-11-17 21:35:03
*/
public interface PlanVersionService extends IService<PlanVersion> {

    PlanVersion selectMaxIdRecord();

    PlanVersion selectByStatus(int projectId, int areaId, int pointId, int status);
}
