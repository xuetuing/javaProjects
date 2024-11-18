package com.example.work.plan.service;

import com.example.work.plan.entity.Plan;
import com.example.work.plan.entity.PlanTemplate;
import com.example.work.plan.template.TemplateIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EbsDataService {

    @Autowired
    PlanTemplateService planTemplateService;

    public List<Plan> generatePlans(Integer templateId) throws Exception {
        // 调 EBS 接口，获取计划数据


        // 处理 EBS 返回的数据

        // 生成 Plan 对象列表 根据模板+ EBS返回的数据
        PlanTemplate template = planTemplateService.getById(templateId);
        String implClass = template.getImplClass();
        Object o = Class.forName(implClass).getDeclaredConstructor().newInstance();
        if (o instanceof TemplateIntf) {
            List<Plan> plans = ((TemplateIntf) o).generatePlans();
        }

        return new ArrayList<>();
    }
}
