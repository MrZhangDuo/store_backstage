package com.hy.store_backstage.commodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("commodity_goout")
public class RepertoryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 出入库主键
     */
    @TableId(value = "goout_id", type = IdType.AUTO)
    private Long gooutId;

    /**
     * 商品主键
     */
    private Long comId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 库存量
     */
    private Long repertoryNumber;

    /**
     * 库存类型
     */
    private String repertoryType;

    /**
     * 操作类型
     */
    private String handleType;


    private  String comSku;
    private Integer comWarning;
    private Double comPrice;
    private String colorName;
    private String sizeName;
    private Integer differBoth;
    private String comImg;
    private LocalDateTime gooutTime;
    private String gooutPerson;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getGooutId() {
        return gooutId;
    }

    public void setGooutId(Long gooutId) {
        this.gooutId = gooutId;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getRepertoryNumber() {
        return repertoryNumber;
    }

    public void setRepertoryNumber(Long repertoryNumber) {
        this.repertoryNumber = repertoryNumber;
    }

    public String getRepertoryType() {
        return repertoryType;
    }

    public void setRepertoryType(String repertoryType) {
        this.repertoryType = repertoryType;
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public String getComSku() {
        return comSku;
    }

    public void setComSku(String comSku) {
        this.comSku = comSku;
    }

    public Integer getComWarning() {
        return comWarning;
    }

    public void setComWarning(Integer comWarning) {
        this.comWarning = comWarning;
    }

    public Double getComPrice() {
        return comPrice;
    }

    public void setComPrice(Double comPrice) {
        this.comPrice = comPrice;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Integer getDifferBoth() {
        return differBoth;
    }

    public void setDifferBoth(Integer differBoth) {
        this.differBoth = differBoth;
    }

    public String getComImg() {
        return comImg;
    }

    public void setComImg(String comImg) {
        this.comImg = comImg;
    }

    public LocalDateTime getGooutTime() {
        return gooutTime;
    }

    public void setGooutTime(LocalDateTime gooutTime) {
        this.gooutTime = gooutTime;
    }

    public String getGooutPerson() {
        return gooutPerson;
    }

    public void setGooutPerson(String gooutPerson) {
        this.gooutPerson = gooutPerson;
    }

    @Override
    public String toString() {
        return "RepertoryBean{" +
                "gooutId=" + gooutId +
                ", comId=" + comId +
                ", orderNo='" + orderNo + '\'' +
                ", repertoryNumber=" + repertoryNumber +
                ", repertoryType='" + repertoryType + '\'' +
                ", handleType='" + handleType + '\'' +
                ", comSku='" + comSku + '\'' +
                ", comWarning=" + comWarning +
                ", comPrice=" + comPrice +
                ", colorName='" + colorName + '\'' +
                ", sizeName='" + sizeName + '\'' +
                ", differBoth=" + differBoth +
                ", comImg='" + comImg + '\'' +
                ", gooutTime=" + gooutTime +
                ", gooutPerson='" + gooutPerson + '\'' +
                '}';
    }
}
