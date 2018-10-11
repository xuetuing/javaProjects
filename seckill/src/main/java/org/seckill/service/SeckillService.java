package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.exception.SeckillRepeatException;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;
@Service
public interface SeckillService {
    Seckill queryById(long seckillId);
    List<Seckill> querySeckillList();
    /**
     * 暴露秒杀接口
     * @return
     */
    Exposer exportKillUrl(long seckillId);

    /**
     * 防止数据篡改
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillRepeatException, SeckillCloseException;
}
