package com.huawei.seckill.common.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "seckill")
public class Seckill implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seckill_id", nullable = false)
    private String seckillId;
    private String name;
    private Integer number;
    private Timestamp startTiem;
    private Timestamp endTiem;
    private Timestamp createTime;
    @Version
    private Integer version;

    public String getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(String seckillId) {
        this.seckillId = seckillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Timestamp getStartTiem() {
        return startTiem;
    }

    public void setStartTiem(Timestamp startTiem) {
        this.startTiem = startTiem;
    }

    public Timestamp getEndTiem() {
        return endTiem;
    }

    public void setEndTiem(Timestamp endTiem) {
        this.endTiem = endTiem;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
