package com.hy.store_backstage.commodity.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("twoclassify")
@Data
public class TwoClassifyEntity {
    private Integer twId;
    private Integer oneId;
    private String twoName;
}
