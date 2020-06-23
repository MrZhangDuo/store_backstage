package com.hy.store_backstage.commodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@TableName("commodity")
public class CommodityEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品主键
     */
    @TableId(value = "com_id", type = IdType.AUTO)
    private Long comId;

    /**
     * 商品编号
     */
    private String comNumber;

    /**
     * 商品名称
     */
    private String comName;

    /**
     * 商品图片
     */
    private String comImg;

    /**
     * 商品价格
     */
    private Double comPrice;

    /**
     * 商品货号
     */
    private String comNo;

    /**
     * 商品标签
     */
    private String comLabel;

    /**
     * 商品库存
     */
    private Long comStock;

    /**
     * 商品销量
     */
    private Long comSales;

    /**
     * 审核状态
     */
    private Integer comState;

    /**
     * 商品品牌
     */
    private String comBrand;

    /**
     * 商品分类
     */

    private Long comType;
    private  String comDetail;



    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "YYYY-mm-dd hh:mm:ss")
    private Date aTime;
    private String aPerson ;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public String getComNumber() {
        return comNumber;
    }

    public void setComNumber(String comNumber) {
        this.comNumber = comNumber;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComImg() {
        return comImg;
    }

    public void setComImg(String comImg) {
        this.comImg = comImg;
    }

    public Double getComPrice() {
        return comPrice;
    }

    public void setComPrice(Double comPrice) {
        this.comPrice = comPrice;
    }

    public String getComNo() {
        return comNo;
    }

    public void setComNo(String comNo) {
        this.comNo = comNo;
    }

    public String getComLabel() {
        return comLabel;
    }

    public void setComLabel(String comLabel) {
        this.comLabel = comLabel;
    }

    public Long getComStock() {
        return comStock;
    }

    public void setComStock(Long comStock) {
        this.comStock = comStock;
    }

    public Long getComSales() {
        return comSales;
    }

    public void setComSales(Long comSales) {
        this.comSales = comSales;
    }

    public Integer getComState() {
        return comState;
    }

    public void setComState(Integer comState) {
        this.comState = comState;
    }

    public String getComBrand() {
        return comBrand;
    }

    public void setComBrand(String comBrand) {
        this.comBrand = comBrand;
    }

    public Long getComType() {
        return comType;
    }

    public void setComType(Long comType) {
        this.comType = comType;
    }

    public String getComDetail() {
        return comDetail;
    }

    public void setComDetail(String comDetail) {
        this.comDetail = comDetail;
    }

    public Date getaTime() {
        return aTime;
    }

    public void setaTime(Date aTime) {
        this.aTime = aTime;
    }

    public String getaPerson() {
        return aPerson;
    }

    public void setaPerson(String aPerson) {
        this.aPerson = aPerson;
    }

    @Override
    public String toString() {
        return "CommodityEntity{" +
                "comId=" + comId +
                ", comNumber='" + comNumber + '\'' +
                ", comName='" + comName + '\'' +
                ", comImg='" + comImg + '\'' +
                ", comPrice=" + comPrice +
                ", comNo='" + comNo + '\'' +
                ", comLabel='" + comLabel + '\'' +
                ", comStock=" + comStock +
                ", comSales=" + comSales +
                ", comState=" + comState +
                ", comBrand=" + comBrand +
                ", comType=" + comType +
                ", comDetail='" + comDetail + '\'' +
                ", aTime=" + aTime +
                ", aPerson='" + aPerson + '\'' +
                '}';
    }
}
