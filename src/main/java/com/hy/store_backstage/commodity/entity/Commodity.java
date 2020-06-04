package com.hy.store_backstage.commodity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品主键
     */
    @TableId(value = "com_id", type = IdType.AUTO)
    private Long com_id;

    /**
     * 商品编号
     */
    private String com_number;

    /**
     * 商品名称
     */
    private String com_name;

    /**
     * 商品图片
     */
    private String com_img;

    /**
     * 商品价格
     */
    private Double com_price;

    /**
     * 商品货号
     */
    private String com_no;

    /**
     * 商品标签
     */
    private String com_label;

    /**
     * 商品库存
     */
    private Long com_stock;

    /**
     * 商品销量
     */
    private Long com_sales;

    /**
     * 审核状态
     */
    private String com_state;

    /**
     * 商品品牌
     */
    private Long com_brand;

    /**
     * 商品分类
     */
    private Long com_type;

    public Long getCom_id() {
        return com_id;
    }

    public void setCom_id(Long com_id) {
        this.com_id = com_id;
    }
    public String getCom_number() {
        return com_number;
    }

    public void setCom_number(String com_number) {
        this.com_number = com_number;
    }
    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }
    public String getCom_img() {
        return com_img;
    }

    public void setCom_img(String com_img) {
        this.com_img = com_img;
    }
    public Double getCom_price() {
        return com_price;
    }

    public void setCom_price(Double com_price) {
        this.com_price = com_price;
    }
    public String getCom_no() {
        return com_no;
    }

    public void setCom_no(String com_no) {
        this.com_no = com_no;
    }
    public String getCom_label() {
        return com_label;
    }

    public void setCom_label(String com_label) {
        this.com_label = com_label;
    }
    public Long getCom_stock() {
        return com_stock;
    }

    public void setCom_stock(Long com_stock) {
        this.com_stock = com_stock;
    }
    public Long getCom_sales() {
        return com_sales;
    }

    public void setCom_sales(Long com_sales) {
        this.com_sales = com_sales;
    }
    public String getCom_state() {
        return com_state;
    }

    public void setCom_state(String com_state) {
        this.com_state = com_state;
    }
    public Long getCom_brand() {
        return com_brand;
    }

    public void setCom_brand(Long com_brand) {
        this.com_brand = com_brand;
    }
    public Long getCom_type() {
        return com_type;
    }

    public void setCom_type(Long com_type) {
        this.com_type = com_type;
    }

    @Override
    public String toString() {
        return "Commodity{" +
        "com_id=" + com_id +
        ", com_number=" + com_number +
        ", com_name=" + com_name +
        ", com_img=" + com_img +
        ", com_price=" + com_price +
        ", com_no=" + com_no +
        ", com_label=" + com_label +
        ", com_stock=" + com_stock +
        ", com_sales=" + com_sales +
        ", com_state=" + com_state +
        ", com_brand=" + com_brand +
        ", com_type=" + com_type +
        "}";
    }
}
