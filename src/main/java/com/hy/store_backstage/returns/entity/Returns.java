package com.hy.store_backstage.returns.entity;

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
public class Returns implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 退款(货)
     */
    @TableId(value = "return_id", type = IdType.AUTO)
    private Long return_id;

    /**
     * 服务单号
     */
    private String service_no;

    /**
     * 申请时间
     */
    private LocalDateTime applyfor_time;

    /**
     * 客户账号
     */
    private String cust_account;

    /**
     * 退款金额
     */
    private Double return_money;

    /**
     * 申请状态
     */
    private String applyfor_status;

    /**
     * 处理时间
     */
    private LocalDateTime manage_time;

    private String return_type;

    public Long getReturn_id() {
        return return_id;
    }

    public void setReturn_id(Long return_id) {
        this.return_id = return_id;
    }
    public String getService_no() {
        return service_no;
    }

    public void setService_no(String service_no) {
        this.service_no = service_no;
    }
    public LocalDateTime getApplyfor_time() {
        return applyfor_time;
    }

    public void setApplyfor_time(LocalDateTime applyfor_time) {
        this.applyfor_time = applyfor_time;
    }
    public String getCust_account() {
        return cust_account;
    }

    public void setCust_account(String cust_account) {
        this.cust_account = cust_account;
    }
    public Double getReturn_money() {
        return return_money;
    }

    public void setReturn_money(Double return_money) {
        this.return_money = return_money;
    }
    public String getApplyfor_status() {
        return applyfor_status;
    }

    public void setApplyfor_status(String applyfor_status) {
        this.applyfor_status = applyfor_status;
    }
    public LocalDateTime getManage_time() {
        return manage_time;
    }

    public void setManage_time(LocalDateTime manage_time) {
        this.manage_time = manage_time;
    }
    public String getReturn_type() {
        return return_type;
    }

    public void setReturn_type(String return_type) {
        this.return_type = return_type;
    }

    @Override
    public String toString() {
        return "Returns{" +
        "return_id=" + return_id +
        ", service_no=" + service_no +
        ", applyfor_time=" + applyfor_time +
        ", cust_account=" + cust_account +
        ", return_money=" + return_money +
        ", applyfor_status=" + applyfor_status +
        ", manage_time=" + manage_time +
        ", return_type=" + return_type +
        "}";
    }
}
