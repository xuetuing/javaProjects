package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

public interface SeckillDao {
    /**
     * 减库存
     * @return
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killtime") Date killtime);

    /**
     * 根据id查询
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}
