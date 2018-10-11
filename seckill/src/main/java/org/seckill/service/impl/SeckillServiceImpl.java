package org.seckill.service.impl;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.exception.SeckillRepeatException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
@Service
public class SeckillServiceImpl implements SeckillService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String salt = "gjw|3i-4rRPT&*fg@wpr";
    private SeckillDao seckillDao;
    private SuccessKilledDao successKilledDao;

    public Seckill queryById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public List<Seckill> querySeckillList() {
        return seckillDao.queryAll(0,4);
    }

    public Exposer exportKillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if(seckill == null){
            return new Exposer(false,seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime()
                || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime, startTime, endTime);
        }
        String md5 = getMd5(seckillId);
        return new Exposer(true, md5, seckillId);
    }
    private String getMd5(long seckillId){
        String base = seckillId + '/' + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return  md5;
    }
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillRepeatException, SeckillCloseException {
        if (md5 == null || md5.equals(getMd5(seckillId))) {
            throw new SeckillException("seckill data rewrite.");
        }
        //执行秒杀逻辑
        Date nowTime = new Date();
        try {
            //第一步：减库存返回
            int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                throw new SeckillCloseException("seckill is closed.");
            } else {
                //如果减库存成功
                int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
                //判断是否重复秒杀
                if (insertCount <= 0) {
                    throw new SeckillRepeatException("seckill repeat.");
                } else {
                    //秒杀成功
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
                }
            }
        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (SeckillRepeatException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SeckillException("seckill inner error:" + e.getMessage());
        }
    }
}
