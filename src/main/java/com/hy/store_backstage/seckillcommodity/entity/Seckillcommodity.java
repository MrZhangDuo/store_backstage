package com.hy.store_backstage.seckillcommodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-10
 */
@Data
@TableName("seckillcommodity")
public class Seckillcommodity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "secComId", type = IdType.AUTO)
    private Long secComId;

    /**
     * 商品外键
     */
    @TableField(value = "commodityId")
    private Long commodityId;

    /**
     * 秒杀价格
     */
    @TableField(value = "seckillMoney")
    private Double seckillMoney;

    /**
     * 秒杀数量
     */
    @TableField(value = "seckillNumber")
    private Long seckillNumber;

    /**
     * 剩余数量
     */
    @TableField(value = "surplusNumber")
    private Long surplusNumber;

    /**
     * 限购数量
     */
    @TableField(value = "limitNumber")
    private Long limitNumber;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Long sort;

    /**
     * 属于谁的活动
     */
    @TableField(value = "seckillId")
    private Long seckillId;
}
