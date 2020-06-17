package com.hy.store_backstage.returns.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName ReturnsCommodityBo
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/15 10:51
 * @Version 1.0
 */
@Data
public class ReturnsCommodityBo {

    /**
     * 退款(货)
     */
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

    /**
     * 商品主键
     */
    private Integer comId;

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
    private Integer comState;

    /**
     * 商品品牌
     */
    private Integer comBrand;

    /**
     * 商品分类
     */

    private Long comType;
    private  String comDetail;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "YYYY-mm-dd hh:mm:ss")
    private Date aTime;
    private String aPerson ;

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
