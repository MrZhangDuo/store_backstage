package com.hy.store_backstage.commodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName("evaluateson")
public class EvaluateSEntity {

    @TableId(value = "son_id", type = IdType.AUTO)
    private Integer sonId;
    private String sonPerson;
    private LocalDateTime sonTime;
    private String sonContent;
    private Integer evaId;
    private Integer sonIsManage;
    private Integer counts;
    private String sonEmail;
    private String evaUesrname;

    public Integer getSonId() {
        return sonId;
    }

    public void setSonId(Integer sonId) {
        this.sonId = sonId;
    }

    public String getSonPerson() {
        return sonPerson;
    }

    public void setSonPerson(String sonPerson) {
        this.sonPerson = sonPerson;
    }

    public LocalDateTime getSonTime() {
        return sonTime;
    }

    public void setSonTime(LocalDateTime sonTime) {
        this.sonTime = sonTime;
    }

    public String getSonContent() {
        return sonContent;
    }

    public void setSonContent(String sonContent) {
        this.sonContent = sonContent;
    }

    public Integer getEvaId() {
        return evaId;
    }

    public void setEvaId(Integer evaId) {
        this.evaId = evaId;
    }

    public Integer getSonIsManage() {
        return sonIsManage;
    }

    public void setSonIsManage(Integer sonIsManage) {
        this.sonIsManage = sonIsManage;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getSonEmail() {
        return sonEmail;
    }

    public void setSonEmail(String sonEmail) {
        this.sonEmail = sonEmail;
    }

    public String getEvaUesrname() {
        return evaUesrname;
    }

    public void setEvaUesrname(String evaUesrname) {
        this.evaUesrname = evaUesrname;
    }

    @Override
    public String toString() {
        return "EvaluateSEntity{" +
                "sonId=" + sonId +
                ", sonPerson='" + sonPerson + '\'' +
                ", sonTime=" + sonTime +
                ", sonContent='" + sonContent + '\'' +
                ", evaId=" + evaId +
                ", sonIsManage=" + sonIsManage +
                ", counts=" + counts +
                ", sonEmail='" + sonEmail + '\'' +
                ", evaUesrname='" + evaUesrname + '\'' +
                '}';
    }
}
