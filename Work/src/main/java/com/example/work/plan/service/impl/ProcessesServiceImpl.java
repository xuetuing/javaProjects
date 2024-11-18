package com.example.work.plan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.work.plan.entity.Processes;
import com.example.work.plan.service.ProcessesService;
import com.example.work.plan.mapper.ProcessesMapper;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【processes(施工工序表)】的数据库操作Service实现
* @createDate 2024-11-17 21:35:03
*/
@Service
public class ProcessesServiceImpl extends ServiceImpl<ProcessesMapper, Processes>
    implements ProcessesService{

}




