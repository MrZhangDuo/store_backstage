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
    private Long affirm_id;

    /**
     * 订单编号
     */
    private String affirm_no;

    /**
     * 确认收货时间
     */
    private LocalDateTime affirm_time;

    /**
     * 确认收货用户账号
     */
    private String affirm_cust_account;

    /**
     * 确认收货人
     */
    private String affirm_people;

    /**
     * 订单金额
     */
    private Double order_mony;

    /**
     * 订单状态
     */
    private String order_status;

    public Long getAffirm_id() {
        return affirm_id;
    }

    public void setAffirm_id(Long affirm_id) {
        this.affirm_id = affirm_id;
    }
    public String getAffirm_no() {
        return affirm_no;
    }

    public void setAffirm_no(String affirm_no) {
        this.affirm_no = affirm_no;
    }
    public LocalDateTime getAffirm_time() {
        return affirm_time;
    }

    public void setAffirm_time(LocalDateTime affirm_time) {
        this.affirm_time = affirm_time;
    }
    public String getAffirm_cust_account() {
        return affirm_cust_account;
    }

    public void setAffirm_cust_account(String affirm_cust_account) {
        this.affirm_cust_account = affirm_cust_account;
    }
    public String getAffirm_people() {
        return affirm_people;
    }

    public void setAffirm_people(String affirm_people) {
        this.affirm_people = affirm_people;
    }
    public Double getOrder_mony() {
        return order_mony;
    }

    public void setOrder_mony(Double order_mony) {
        this.order_mony = order_mony;
    }
    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "Affirm{" +
        "affirm_id=" + affirm_id +
        ", affirm_no=" + affirm_no +
        ", affirm_time=" + affirm_time +
        ", affirm_cust_account=" + affirm_cust_account +
        ", affirm_people=" + affirm_people +
        ", order_mony=" + order_mony +
        ", order_status=" + order_status +
        "}";
    }
}
