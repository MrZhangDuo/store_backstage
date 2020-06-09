package com.hy.store_backstage.seckill.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-05
 */
@Data
@TableName("seckill")
public class Seckill implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 秒杀编号
     */
    @TableId(value = "seckillId", type = IdType.AUTO)
    private Long seckillId;

    /**
     * 秒杀主题
     */
    private String seckillTitle;

    /**
     * 秒杀状态
     */
    private Boolean seckillStatus;

    /**
     * 秒杀开始时间段
     */
    private LocalDateTime startTime;

    /**
     * 秒杀结束时间段
     */
    private LocalDateTime endTime;

    /**
     * 参与活动的商品个数
     */
    @TableField(exist = false)
    private Long seckillComNum;


}
