package org.seckill.dao;

import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
    /**
     * 插入秒杀成功明细，防止重复秒杀
     * @return
     */
    int insertSuccessKilled(long seckillId, long userPhone);

    /**
     * 根据id查询，并携带秒杀实体
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(long seckillId);
}
