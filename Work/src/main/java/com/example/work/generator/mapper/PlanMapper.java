package com.example.work.generator.mapper;

import com.example.work.generator.entity.Plan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author DELL
* @description 针对表【plan】的数据库操作Mapper
* @createDate 2024-11-17 12:01:10
* @Entity com.example.work.generator.entity.Plan
*/
public interface PlanMapper extends BaseMapper<Plan> {
    int insert(Plan plan);
}



