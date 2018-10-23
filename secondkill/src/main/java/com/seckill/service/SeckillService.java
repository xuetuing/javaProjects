package com.seckill.service;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;

import java.util.List;

public interface SeckillService {
    //查询列表
    List<Seckill> queryList();

    //查询单个Seckill
    Seckill queryById(Long seckillId);

    //暴露秒杀接口
    Exposer exposeKillUrl(Long seckillId);

    //执行秒杀
    SeckillExecution executeSeckill(Long SeckillId, Long userPhont, String md5);
}
