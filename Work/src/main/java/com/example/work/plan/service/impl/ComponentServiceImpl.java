package com.example.work.plan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.work.plan.entity.Component;
import com.example.work.plan.service.ComponentService;
import com.example.work.plan.mapper.ComponentMapper;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【component(构件表)】的数据库操作Service实现
* @createDate 2024-11-17 21:35:03
*/
@Service
public class ComponentServiceImpl extends ServiceImpl<ComponentMapper, Component>
    implements ComponentService{

}




