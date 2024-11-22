package com.example.work.plan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.work.plan.entity.WorkPoint;
import com.example.work.plan.service.WorkPointService;
import com.example.work.plan.mapper.WorkPointMapper;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【work_point】的数据库操作Service实现
* @createDate 2024-11-17 21:35:03
*/
@Service
public class WorkPointServiceImpl extends ServiceImpl<WorkPointMapper, WorkPoint>
    implements WorkPointService{

}



