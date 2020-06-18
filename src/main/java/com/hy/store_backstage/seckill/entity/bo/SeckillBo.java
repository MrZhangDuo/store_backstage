package com.hy.store_backstage.seckill.entity.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName SeckillBo
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/5 14:42
 * @Version 1.0
 */
@Data
public class SeckillBo {

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )/* 前端转后端格式化时间注解 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "Asia/Shanghai")
    private LocalDateTime startTime;

    /**
     * 秒杀结束时间段
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )//前台传后台时, 字符串自动封装成日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "Asia/Shanghai") // 后台返给前台时, 日期自动格式化
    private LocalDateTime endTime;

    /**
     * 秒杀排序
     */
    private Long sort;

    /**
     * 参与活动的商品个数
     */
    private Long seckillComNum;
}
