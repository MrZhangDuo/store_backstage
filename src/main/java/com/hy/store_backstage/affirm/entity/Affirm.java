package com.hy.store_backstage.affirm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

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
@Data
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
}
