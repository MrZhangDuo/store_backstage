package com.hy.store_backstage.seckillcommodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName SeckillCommodityBo
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/10 15:19
 * @Version 1.0
 */
@Data
public class SeckillCommodityBo {
    /**
     * 编号
     */
    @TableId(value = "secComId", type = IdType.AUTO)
    private Long secComId;

    /**
     * 商品外键
     */
    private Long commodityId;

    /**
     * 秒杀价格
     */
    private Double seckillMoney;

    /**
     * 秒杀数量
     */
    private Long seckillNumber;

    /**
     * 剩余数量
     */
    private Long surplusNumber;

    /**
     * 限购数量
     */
    private Long limitNumber;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 属于谁的活动
     */
    private Long seckillId;

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
}
