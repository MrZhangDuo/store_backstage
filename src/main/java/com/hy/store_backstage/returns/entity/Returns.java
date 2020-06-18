package com.hy.store_backstage.returns.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@TableName("returns")
@Data
public class Returns implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 退款(货)
     */
    @TableId(value = "return_id", type = IdType.AUTO)
    private Long returnId;

    /**
     * 服务单号
     */
    private Long orderid;

    /**
     * 申请时间
     */
    private LocalDateTime applyforTime;

    /**
     * 客户账号
     */
    private String custAccount;

    /**
     * 退款金额
     */
    private Double returnMoney;

    /**
     * 申请状态
     */
    private String applyforStatus;

    /**
     * 处理时间
     */
    private LocalDateTime manageTime;

    /**
     * 申请类型
     */
    private String returnType;

    /**
     * 申请原因
     */
    private String returnReason;

    /**
     * 申请商品
     */
    private Long return_commodity;

    @TableField(exist = false)
    /**
     * 订单编号
     */
    private String orderNo;
}
