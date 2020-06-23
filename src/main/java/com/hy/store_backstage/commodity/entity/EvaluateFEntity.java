package com.hy.store_backstage.commodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("evaluatefather")
public class EvaluateFEntity {
    @TableId(value = "eva_id", type = IdType.AUTO)
    private Integer evaId;
    private String evaUesrname;
    private String evaComname;
    private String evaEvaluate;
    private LocalDateTime evaTime;
    private String evaIstrue;
    private Integer evaStar;
    private Integer evaCollect;
    private Integer evaReads;


    public Integer getEvaId() {
        return evaId;
    }

    public void setEvaId(Integer evaId) {
        this.evaId = evaId;
    }

    public String getEvaUesrname() {
        return evaUesrname;
    }

    public void setEvaUesrname(String evaUesrname) {
        this.evaUesrname = evaUesrname;
    }

    public String getEvaComname() {
        return evaComname;
    }

    public void setEvaComname(String evaComname) {
        this.evaComname = evaComname;
    }

    public String getEvaEvaluate() {
        return evaEvaluate;
    }

    public void setEvaEvaluate(String evaEvaluate) {
        this.evaEvaluate = evaEvaluate;
    }

    public LocalDateTime getEvaTime() {
        return evaTime;
    }

    public void setEvaTime(LocalDateTime evaTime) {
        this.evaTime = evaTime;
    }

    public String getEvaIstrue() {
        return evaIstrue;
    }

    public void setEvaIstrue(String evaIstrue) {
        this.evaIstrue = evaIstrue;
    }

    public Integer getEvaStar() {
        return evaStar;
    }

    public void setEvaStar(Integer evaStar) {
        this.evaStar = evaStar;
    }

    public Integer getEvaCollect() {
        return evaCollect;
    }

    public void setEvaCollect(Integer evaCollect) {
        this.evaCollect = evaCollect;
    }

    public Integer getEvaReads() {
        return evaReads;
    }

    public void setEvaReads(Integer evaReads) {
        this.evaReads = evaReads;
    }

    @Override
    public String toString() {
        return "EvaluateFEntity{" +
                "evaId=" + evaId +
                ", evaUesrname='" + evaUesrname + '\'' +
                ", evaComname='" + evaComname + '\'' +
                ", evaEvaluate='" + evaEvaluate + '\'' +
                ", evaTime=" + evaTime +
                ", evaIstrue='" + evaIstrue + '\'' +
                ", evaStar=" + evaStar +
                ", evaCollect=" + evaCollect +
                ", evaReads=" + evaReads +
                '}';
    }
}
