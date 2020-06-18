package com.hy.store_backstage.commodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("colors")
public class ColorEntity implements Serializable {
    @TableId(value = "color_id", type = IdType.AUTO)
    private Integer colorId;
    private String colorName;

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }


    @Override
    public String toString() {
        return "ColorEntity{" +
                "colorId=" + colorId +
                ", colorName='" + colorName + '\'' +
                '}';
    }
}
