package org.seckill.dao.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-*.xml")
public class RedisDaoTest {
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private SeckillService seckillService;
    @Test
    public void getSeckill() {
        long id = 1000;
        Seckill seckill = redisDao.getSeckill(id);
        System.out.println(seckill.toString());
    }

    @Test
    public void putSeckill() {
        Seckill seckill = seckillService.queryById(1000);
        if (seckill == null) {
            System.out.println("no seckill!");
        } else {
            redisDao.putSeckill(seckill);
        }
    }
}
