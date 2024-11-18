package com.example.work.plan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.work.plan.entity.PlanVersion;
import com.example.work.plan.service.PlanVersionService;
import com.example.work.plan.mapper.PlanVersionMapper;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【plan_version】的数据库操作Service实现
* @createDate 2024-11-17 21:35:03
*/
@Service
public class PlanVersionServiceImpl extends ServiceImpl<PlanVersionMapper, PlanVersion>
    implements PlanVersionService{

    @Override
    public PlanVersion selectMaxIdRecord() {
        return baseMapper.selectMaxIdRecord();
    }

    @Override
    public PlanVersion selectByStatus(int projectId, int areaId, int pointId, int status) {
        return baseMapper.selectByStatus(projectId, areaId, pointId, status);
    }
}




