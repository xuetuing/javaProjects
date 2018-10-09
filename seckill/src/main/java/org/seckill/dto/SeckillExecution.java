package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStateEnum;

public class SeckillExecution {
    private long seckillId;
    private SeckillStateEnum state;
    //秒杀成功时返回successKilled
    private SuccessKilled successKilled;

    public SeckillExecution(long seckillId, SeckillStateEnum state, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = state;
        this.successKilled = successKilled;
    }

    public SeckillExecution(long seckillId, SeckillStateEnum state) {
        this.seckillId = seckillId;
        this.state = state;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public SeckillStateEnum getState() {
        return state;
    }

    public void setState(SeckillStateEnum state) {
        this.state = state;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}
