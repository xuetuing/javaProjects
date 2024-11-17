package com.example.work.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.work.generator.entity.Component;
import com.example.work.generator.service.ComponentService;
import com.example.work.generator.mapper.ComponentMapper;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【component(构件表)】的数据库操作Service实现
* @createDate 2024-11-17 12:01:10
*/
@Service
public class ComponentServiceImpl extends ServiceImpl<ComponentMapper, Component>
    implements ComponentService{

}




