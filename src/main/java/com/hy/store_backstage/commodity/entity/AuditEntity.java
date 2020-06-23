package com.hy.store_backstage.commodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("audit")
public class AuditEntity implements Serializable {
    @TableId(value = "a_id", type = IdType.AUTO)
    private Integer aId;
    private Integer comId;
    private LocalDateTime aTime;
    private String aPerson ;
    private Integer comState ;
    private String comDetail;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public LocalDateTime getaTime() {
        return aTime;
    }

    public void setaTime(LocalDateTime aTime) {
        this.aTime = aTime;
    }

    public String getaPerson() {
        return aPerson;
    }

    public void setaPerson(String aPerson) {
        this.aPerson = aPerson;
    }

    public Integer getComState() {
        return comState;
    }

    public void setComState(Integer comState) {
        this.comState = comState;
    }

    public String getComDetail() {
        return comDetail;
    }

    public void setComDetail(String comDetail) {
        this.comDetail = comDetail;
    }

    @Override
    public String toString() {
        return "AuditEntity{" +
                "aId=" + aId +
                ", comId=" + comId +
                ", aTime=" + aTime +
                ", aPerson='" + aPerson + '\'' +
                ", comState=" + comState +
                ", comDetail='" + comDetail + '\'' +
                '}';
    }
}
