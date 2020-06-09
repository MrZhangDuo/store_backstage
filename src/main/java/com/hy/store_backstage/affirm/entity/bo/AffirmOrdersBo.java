//package com.hy.store_backstage.affirm.entity.bo;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableId;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
///**
// * @ClassName AffirmOrdersBo
// * @Description TODO
// * @Author zhangduo
// * @Date 2020/6/5 15:45
// * @Version 1.0
// */
//@Data
//public class AffirmOrdersBo {
//
//    /**
//     * 确认收货主键
//     */
//    @TableId(value = "affirm_id", type = IdType.AUTO)
//    private Long affirmId;
//
//    /**
//     * 订单编号
//     */
//    private String affirmNo;
//
//    /**
//     * 确认收货时间
//     */
//    private LocalDateTime affirmTime;
//
//    /**
//     * 确认收货用户账号
//     */
//    private String affirmCustAccount;
//
//    /**
//     * 确认收货人
//     */
//    private String affirmPeople;
//
//    /**
//     * 订单金额
//     */
//    private Double orderMony;
//
//    /**
//     * 订单状态
//     */
//    private String orderStatus;
//
//    /**
//     * 订单主键
//     */
//    private Long orderId;
//
//    /**
//     * 订单编号
//     */
//    private String orderNo;
//
//    /**
//     * 订单人(收货人)
//     */
//    private String orderPeople;
//
//    /**
//     * 订单商品外键
//     */
//    private Long orderCommodity;
//
//    /**
//     * 订单地址
//     */
//    private String orderAddress;
//
//    /**
//     * 订单时间
//     */
//    private LocalDateTime orderTime;
//
//    /**
//     * 订单金额
//     */
//    private Double orderMony;
//
//    /**
//     * 订单数量
//     */
//    private Long orderNumber;
//
//    /**
//     * 订单状态
//     */
//    private String orderStatus;
//
//}
