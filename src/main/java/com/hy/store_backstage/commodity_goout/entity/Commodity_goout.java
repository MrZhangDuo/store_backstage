package com.hy.store_backstage.commodity_goout.entity;

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
public class Commodity_goout implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 出入库主键
     */
    @TableId(value = "goout_id", type = IdType.AUTO)
    private Long goout_id;

    /**
     * 商品主键
     */
    private Long com_id;

    /**
     * 订单号
     */
    private String order_no;

    /**
     * 库存量
     */
    private Long repertory_number;

    /**
     * 库存类型
     */
    private String repertory_type;

    /**
     * 操作类型
     */
    private String handle_type;


    private  String com_SKU;
    private Integer com_warning;
    private Double com_price;
    private Integer color_id;
    private Integer size_id;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getGoout_id() {
        return goout_id;
    }

    public void setGoout_id(Long goout_id) {
        this.goout_id = goout_id;
    }

    public Long getCom_id() {
        return com_id;
    }

    public void setCom_id(Long com_id) {
        this.com_id = com_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public Long getRepertory_number() {
        return repertory_number;
    }

    public void setRepertory_number(Long repertory_number) {
        this.repertory_number = repertory_number;
    }

    public String getRepertory_type() {
        return repertory_type;
    }

    public void setRepertory_type(String repertory_type) {
        this.repertory_type = repertory_type;
    }

    public String getHandle_type() {
        return handle_type;
    }

    public void setHandle_type(String handle_type) {
        this.handle_type = handle_type;
    }

    public String getCom_SKU() {
        return com_SKU;
    }

    public void setCom_SKU(String com_SKU) {
        this.com_SKU = com_SKU;
    }

    public Integer getCom_warning() {
        return com_warning;
    }

    public void setCom_warning(Integer com_warning) {
        this.com_warning = com_warning;
    }

    public Double getCom_price() {
        return com_price;
    }

    public void setCom_price(Double com_price) {
        this.com_price = com_price;
    }

    public Integer getColor_id() {
        return color_id;
    }

    public void setColor_id(Integer color_id) {
        this.color_id = color_id;
    }

    public Integer getSize_id() {
        return size_id;
    }

    public void setSize_id(Integer size_id) {
        this.size_id = size_id;
    }

    @Override
    public String toString() {
        return "Commodity_goout{" +
                "goout_id=" + goout_id +
                ", com_id=" + com_id +
                ", order_no='" + order_no + '\'' +
                ", repertory_number=" + repertory_number +
                ", repertory_type='" + repertory_type + '\'' +
                ", handle_type='" + handle_type + '\'' +
                ", com_SKU='" + com_SKU + '\'' +
                ", com_warning=" + com_warning +
                ", com_price=" + com_price +
                ", color_id=" + color_id +
                ", size_id=" + size_id +
                '}';
    }
}
