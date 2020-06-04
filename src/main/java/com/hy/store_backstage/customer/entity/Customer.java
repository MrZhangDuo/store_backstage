package com.hy.store_backstage.customer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户主键
     */
    @TableId(value = "cust_id", type = IdType.AUTO)
    private Long cust_id;

    /**
     * 客户账号
     */
    private String cust_account;

    /**
     * 客户昵称
     */
    private String cust_name;

    /**
     * 会员等级
     */
    private String vip_grade;

    /**
     * 消费金额
     */
    private Double cust_money;

    /**
     * 订单数量
     */
    private Long order_number;

    /**
     * 账号状态
     */
    private String account_status;

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }
    public String getCust_account() {
        return cust_account;
    }

    public void setCust_account(String cust_account) {
        this.cust_account = cust_account;
    }
    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
    public String getVip_grade() {
        return vip_grade;
    }

    public void setVip_grade(String vip_grade) {
        this.vip_grade = vip_grade;
    }
    public Double getCust_money() {
        return cust_money;
    }

    public void setCust_money(Double cust_money) {
        this.cust_money = cust_money;
    }
    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
    }
    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }

    @Override
    public String toString() {
        return "Customer{" +
        "cust_id=" + cust_id +
        ", cust_account=" + cust_account +
        ", cust_name=" + cust_name +
        ", vip_grade=" + vip_grade +
        ", cust_money=" + cust_money +
        ", order_number=" + order_number +
        ", account_status=" + account_status +
        "}";
    }
}
