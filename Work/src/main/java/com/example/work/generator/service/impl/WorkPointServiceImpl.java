package com.example.work.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.work.generator.entity.WorkPoint;
import com.example.work.generator.service.WorkPointService;
import com.example.work.generator.mapper.WorkPointMapper;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【work_point(工点)】的数据库操作Service实现
* @createDate 2024-11-17 12:01:10
*/
@Service
public class WorkPointServiceImpl extends ServiceImpl<WorkPointMapper, WorkPoint>
    implements WorkPointService{

}




