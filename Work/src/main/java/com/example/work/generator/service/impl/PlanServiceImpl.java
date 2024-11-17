package com.example.work.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.work.generator.entity.Plan;
import com.example.work.generator.service.PlanService;
import com.example.work.generator.mapper.PlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【plan】的数据库操作Service实现
* @createDate 2024-11-17 12:01:10
*/
@Service
public class PlanServiceImpl extends ServiceImpl<PlanMapper, Plan>
    implements PlanService{

    @Autowired
    PlanMapper planMapper;

    @Override
    public int insert(Plan plan) {
        return planMapper.insert(plan);
    }
}



