package com.example.work.plan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.work.plan.entity.Plan;
import com.example.work.plan.entity.PlanVersion;
import com.example.work.plan.service.PlanService;
import com.example.work.plan.mapper.PlanMapper;
import com.example.work.plan.service.PlanVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author DELL
* @description 针对表【plan】的数据库操作Service实现
* @createDate 2024-11-17 21:35:03
*/
@Service
public class PlanServiceImpl extends ServiceImpl<PlanMapper, Plan>
    implements PlanService{

    @Autowired
    PlanVersionService planVersionService;

    @Override
    public void batchSave(List<Plan> plans, boolean isDraft){

        // 状态 0已停用 1当前执行 2未发布
        Plan plan = plans.get(0);
        Integer projectId = plan.getProjectId();
        Integer areaId = plan.getAreaId();
        Integer pointId = plan.getPointId();

        PlanVersion planVersion = planVersionService.selectByStatus(projectId, areaId, pointId, 2);
        if (planVersion != null && isDraft) {
            this.saveBatch(plans);
            return;
        } else if (planVersion != null && !isDraft) {
            planVersion.setStatus(1);
            planVersionService.updateById(planVersion);
            return;
        }

        int status = isDraft ? 2 : 1;
        PlanVersion maxVersion = planVersionService.selectMaxIdRecord();
        int maxId = maxVersion == null ? 0 : maxVersion.getId();

        String version = "v" + (maxId + 1);
        PlanVersion newVersion = PlanVersion.builder()
                                    .status(status)
                                    .version(version)
                                    .areaId(plans.get(0).getAreaId())
                                    .pointId(plans.get(0).getPointId())
                                    .projectId(plans.get(0).getProjectId())
                                    .build();
        planVersionService.save(newVersion);

        plans.forEach(pl -> pl.setVersion(version));
        if (!isDraft) {
            maxVersion.setStatus(0);
        }
        this.saveBatch(plans);
    }
}




