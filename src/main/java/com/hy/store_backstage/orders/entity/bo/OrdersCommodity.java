package com.hy.store_backstage.orders.entity.bo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName OrdersCommodity
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/4 19:49
 * @Version 1.0
 */
@Data
public class OrdersCommodity {

    /**
     * 订单主键
     */
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

    /**
     * 商品主键
     */
    private Long comId;

    /**
     * 商品编号
     */
    private String comNumber;

    /**
     * 商品名称
     */
    private String comName;

    /**
     * 商品图片
     */
    private String comImg;

    /**
     * 商品价格
     */
    private Double comPrice;

    /**
     * 商品货号
     */
    private String comNo;

    /**
     * 商品标签
     */
    private String comLabel;

    /**
     * 商品库存
     */
    private Long comStock;

    /**
     * 商品销量
     */
    private Long comSales;

    /**
     * 审核状态
     */
    private String comState;

    /**
     * 商品品牌
     */
    private Long comBrand;

    /**
     * 商品分类
     */
    private Long comType;


}
