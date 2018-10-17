package com.seckill.dao;

import com.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
    //插入秒杀明细
    int insertSuccessKilled(Long seckillId, Long userPhone);
    //查询单个明细
    SuccessKilled queryByIdWithSeckill(Long seckillId, Long userPhone);
}
