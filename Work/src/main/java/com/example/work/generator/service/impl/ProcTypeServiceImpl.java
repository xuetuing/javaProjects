package com.example.work.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.work.generator.entity.ProcType;
import com.example.work.generator.service.ProcTypeService;
import com.example.work.generator.mapper.ProcTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【proc_type(工序规格表)】的数据库操作Service实现
* @createDate 2024-11-17 12:01:10
*/
@Service
public class ProcTypeServiceImpl extends ServiceImpl<ProcTypeMapper, ProcType>
    implements ProcTypeService{

}




