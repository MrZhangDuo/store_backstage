package com.hy.store_backstage.orders.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单主键
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 订单人(收货人)
     */
    private String orderPeople;

    /**
     * 订单商品外键
     */
    private Long orderCommodity;

    /**
     * 订单地址
     */
    private String orderAddress;

    /**
     * 订单时间
     */
    private LocalDateTime orderTime;

    /**
     * 订单金额
     */
    private Double orderMony;

    /**
     * 订单数量
     */
    private Long orderNumber;

    /**
     * 订单状态
     */
    private String orderStatus;

}
