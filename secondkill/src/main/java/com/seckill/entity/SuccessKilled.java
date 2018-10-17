package com.seckill.entity;
//用户执行秒杀结果类
public class SuccessKilled {
    private Long seckillId;
    private Long userPhon;
    private Integer state;
    private Seckill seckill;

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public Long getUserPhon() {
        return userPhon;
    }

    public void setUserPhon(Long userPhon) {
        this.userPhon = userPhon;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckillId=" + seckillId +
                ", userPhon=" + userPhon +
                ", state=" + state +
                ", seckill=" + seckill +
                '}';
    }
}
