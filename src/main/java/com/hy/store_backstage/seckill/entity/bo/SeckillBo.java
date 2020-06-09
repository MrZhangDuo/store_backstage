package com.hy.store_backstage.seckill.entity.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

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
    private LocalDateTime startTime;

    /**
     * 秒杀结束时间段
     */
    private LocalDateTime endTime;

    /**
     * 参与活动的商品个数
     */
    private Long seckillComNum;
}
