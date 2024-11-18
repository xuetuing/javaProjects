package com.example.work.plan.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.work.plan.entity.PlanVersion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
* @author DELL
* @description 针对表【plan_version】的数据库操作Mapper
* @createDate 2024-11-17 21:35:03
* @Entity com.example.work.plan.entity.PlanVersion
*/
public interface PlanVersionMapper extends BaseMapper<PlanVersion> {

    default PlanVersion selectMaxIdRecord() {
        QueryWrapper<PlanVersion> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*")
                .lambda()
                .eq(PlanVersion::getId, findMaxId());
        return selectOne(queryWrapper);
    }

    @Select("select COALESCE(max(id), 0) from plan_version")
    int findMaxId();

    @Select("select * from plan_version where project_id=#{arg0} and area_id=#{arg1} and point_id=#{arg2} and status=#{arg3}")
    PlanVersion selectByStatus(int projectId, int areaId, int pointId, int status);
}




