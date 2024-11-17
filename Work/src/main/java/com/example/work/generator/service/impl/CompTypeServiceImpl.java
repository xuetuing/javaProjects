package com.example.work.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.work.generator.entity.CompType;
import com.example.work.generator.service.CompTypeService;
import com.example.work.generator.mapper.CompTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【comp_type(构件规格表)】的数据库操作Service实现
* @createDate 2024-11-17 12:01:10
*/
@Service
public class CompTypeServiceImpl extends ServiceImpl<CompTypeMapper, CompType>
    implements CompTypeService{

}




