package com.seckill.dao;

import com.seckill.entity.Seckill;

import java.util.List;

public interface SeckillDao {
    //根据id查询Seckill
    Seckill queryById(Long seckillId);
    //查询所有Seckill
    List<Seckill> queryAll();
    //减库存操作
    int reduceNumber(Long seckillId, Long killTime);
}
