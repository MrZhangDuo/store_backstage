package com.hy.store_backstage.orders.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单主键
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Long order_id;

    /**
     * 订单编号
     */
    private String order_no;

    /**
     * 订单人(收货人)
     */
    private String order_people;

    /**
     * 订单商品外键
     */
    private Long order_commodity;

    /**
     * 订单地址
     */
    private String order_address;

    /**
     * 订单时间
     */
    private LocalDateTime order_time;

    /**
     * 订单金额
     */
    private Double order_mony;

    /**
     * 订单数量
     */
    private Long order_number;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }
    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }
    public String getOrder_people() {
        return order_people;
    }

    public void setOrder_people(String order_people) {
        this.order_people = order_people;
    }
    public Long getOrder_commodity() {
        return order_commodity;
    }

    public void setOrder_commodity(Long order_commodity) {
        this.order_commodity = order_commodity;
    }
    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }
    public LocalDateTime getOrder_time() {
        return order_time;
    }

    public void setOrder_time(LocalDateTime order_time) {
        this.order_time = order_time;
    }
    public Double getOrder_mony() {
        return order_mony;
    }

    public void setOrder_mony(Double order_mony) {
        this.order_mony = order_mony;
    }
    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
    }

    @Override
    public String toString() {
        return "Orders{" +
        "order_id=" + order_id +
        ", order_no=" + order_no +
        ", order_people=" + order_people +
        ", order_commodity=" + order_commodity +
        ", order_address=" + order_address +
        ", order_time=" + order_time +
        ", order_mony=" + order_mony +
        ", order_number=" + order_number +
        "}";
    }
}
