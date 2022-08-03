package com.huawei.seckill.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
@Entity
@Table(name = "success_killed")
public class SuccessKilled implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @Column(name = "seckill_id", nullable = false)
    private Long seckillId;
    @Id
    private Long userId;
    private Short state;
    private Timestamp createTime;

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
