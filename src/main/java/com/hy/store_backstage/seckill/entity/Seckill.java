package com.hy.store_backstage.seckill.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

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
    @TableField(value = "seckillTitle")
    private String seckillTitle;

    /**
     * 秒杀状态
     */
    @TableField(value = "seckillStatus")
    private Boolean seckillStatus;

    /**
     * 秒杀开始时间段
     */
    @TableField(value = "startTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )/* 前端转后端格式化时间注解 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "Asia/Shanghai") // 后台返给前台时, 日期自动格式化
    private LocalDateTime startTime;

    /**
     * 秒杀结束时间段
     */
    @TableField(value = "endTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )/* 前端转后端格式化时间注解 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "Asia/Shanghai") // 后台返给前台时, 日期自动格式化
    private LocalDateTime endTime;

    /**
     * 秒杀排序
     */
    private Long sort;

    /**
     * 参与活动的商品个数
     */
    @TableField(exist = false)
    private Long seckillComNum;


}
