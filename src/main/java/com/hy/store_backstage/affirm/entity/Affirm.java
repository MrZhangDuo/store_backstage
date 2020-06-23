package com.hy.store_backstage.affirm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
public class Affirm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 确认收货主键
     */
    @TableId(value = "affirm_id", type = IdType.AUTO)
    private Long affirmId;

    /**
     * 订单编号
     */
    private String affirmNo;

    /**
     * 确认收货时间
     */
    private LocalDateTime affirmTime;

    /**
     * 确认收货用户账号
     */
    private String affirmCustAccount;

    /**
     * 确认收货人
     */
    private String affirmPeople;

    /**
     * 订单金额
     */
    private Double orderMony;

    /**
     * 订单状态
     */
    private String orderStatus;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getAffirmId() {
        return affirmId;
    }

    public void setAffirmId(Long affirmId) {
        this.affirmId = affirmId;
    }

    public String getAffirmNo() {
        return affirmNo;
    }

    public void setAffirmNo(String affirmNo) {
        this.affirmNo = affirmNo;
    }

    public LocalDateTime getAffirmTime() {
        return affirmTime;
    }

    public void setAffirmTime(LocalDateTime affirmTime) {
        this.affirmTime = affirmTime;
    }

    public String getAffirmCustAccount() {
        return affirmCustAccount;
    }

    public void setAffirmCustAccount(String affirmCustAccount) {
        this.affirmCustAccount = affirmCustAccount;
    }

    public String getAffirmPeople() {
        return affirmPeople;
    }

    public void setAffirmPeople(String affirmPeople) {
        this.affirmPeople = affirmPeople;
    }

    public Double getOrderMony() {
        return orderMony;
    }

    public void setOrderMony(Double orderMony) {
        this.orderMony = orderMony;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Affirm{" +
                "affirmId=" + affirmId +
                ", affirmNo='" + affirmNo + '\'' +
                ", affirmTime=" + affirmTime +
                ", affirmCustAccount='" + affirmCustAccount + '\'' +
                ", affirmPeople='" + affirmPeople + '\'' +
                ", orderMony=" + orderMony +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
