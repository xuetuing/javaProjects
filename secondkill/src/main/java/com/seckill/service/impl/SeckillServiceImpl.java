package com.seckill.service.impl;

import com.seckill.dao.SeckillDao;
import com.seckill.dao.SuccessKilledDao;
import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.entity.SuccessKilled;
import com.seckill.enums.SeckillStateEnum;
import com.seckill.exception.SeckillClosedException;
import com.seckill.exception.SeckillException;
import com.seckill.exception.SeckillRepeatException;
import com.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class SeckillServiceImpl implements SeckillService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String salt = "*gwbfg46sf&%^+rwg";

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Override
    public List<Seckill> queryList() {
        return seckillDao.queryAll();
    }

    @Override
    public Seckill queryById(Long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    @Override
    public Exposer exposeKillUrl(Long seckillId) {
        //判断seckill是否存在，从使用的角度，多考虑非正常访问的情况
        //由于时间偏差，后台要对是否开始再一次判断
        Seckill seckill = seckillDao.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime()
                || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, startTime, endTime, nowTime);
        }
        String md5 = getMd5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    @Override
    public SeckillExecution executeSeckill(Long seckillId, Long userPhone, String md5) {
        //减库存，增加秒杀明细
        if (md5 == null || !md5.equals(getMd5(seckillId))) {
            throw new SeckillException("seckill rewrite!");
        }
        try {
            //先增加秒杀明细
            int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
            if (insertCount <= 0) {
                throw new SeckillRepeatException("seckill repeate.");
            } else {
                Date killTime = new Date();
                int updateCount = seckillDao.reduceNumber(seckillId, killTime.getTime());
                if (updateCount <= 0) {
                    throw new SeckillClosedException("seckill closed.");
                }else {
                    //秒杀成功
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
                }

            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    private String getMd5(Long seckillId) {
        String str = seckillId + salt;
        String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
        return md5;
    }
}
