package com.hy.store_backstage.commodity.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

public class GoOutRepertoryBean implements Serializable {
    private  String comImg;
    private  String comName;
    private  String comBrand;
    private  String comNo;
    private  String orderId;
    private String orderNo;
    private BigInteger repertoryNumber;
    private  String handleType;
    private LocalDate gooutTime;
    private String gooutPerson;
    private String colorName;
    private String sizeName;
    private BigInteger gooutNumber;


    public String getComImg() {
        return comImg;
    }

    public void setComImg(String comImg) {
        this.comImg = comImg;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComBrand() {
        return comBrand;
    }

    public void setComBrand(String comBrand) {
        this.comBrand = comBrand;
    }

    public String getComNo() {
        return comNo;
    }

    public void setComNo(String comNo) {
        this.comNo = comNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigInteger getRepertoryNumber() {
        return repertoryNumber;
    }

    public void setRepertoryNumber(BigInteger repertoryNumber) {
        this.repertoryNumber = repertoryNumber;
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public LocalDate getGooutTime() {
        return gooutTime;
    }

    public void setGooutTime(LocalDate gooutTime) {
        this.gooutTime = gooutTime;
    }

    public String getGooutPerson() {
        return gooutPerson;
    }

    public void setGooutPerson(String gooutPerson) {
        this.gooutPerson = gooutPerson;
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

    public BigInteger getGooutNumber() {
        return gooutNumber;
    }

    public void setGooutNumber(BigInteger gooutNumber) {
        this.gooutNumber = gooutNumber;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "GoOutRepertoryBean{" +
                "comImg='" + comImg + '\'' +
                ", comName='" + comName + '\'' +
                ", comBrand='" + comBrand + '\'' +
                ", comNo='" + comNo + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", repertoryNumber=" + repertoryNumber +
                ", handleType='" + handleType + '\'' +
                ", gooutTime=" + gooutTime +
                ", gooutPerson='" + gooutPerson + '\'' +
                ", colorName='" + colorName + '\'' +
                ", sizeName='" + sizeName + '\'' +
                ", gooutNumber=" + gooutNumber +
                '}';
    }
}
