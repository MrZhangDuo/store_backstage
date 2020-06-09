package com.hy.store_backstage.commodity.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("oneclassify")
@Data
public class OneClassifyEntity {
    private Integer oneId;
    private String oneName;
}
