package com.hy.store_backstage.commodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("size")
public class SizeEntity implements Serializable {
    @TableId(value = "size_id", type = IdType.AUTO)
    private Integer sizeId;
    private String sizeName;

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }


    @Override
    public String toString() {
        return "SizeEntity{" +
                "sizeId=" + sizeId +
                ", sizeName='" + sizeName + '\'' +
                '}';
    }
}
