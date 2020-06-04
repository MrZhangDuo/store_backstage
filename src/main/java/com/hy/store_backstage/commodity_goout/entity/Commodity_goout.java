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

    @Override
    public String toString() {
        return "Commodity_goout{" +
        "goout_id=" + goout_id +
        ", com_id=" + com_id +
        ", order_no=" + order_no +
        ", repertory_number=" + repertory_number +
        ", repertory_type=" + repertory_type +
        ", handle_type=" + handle_type +
        "}";
    }
}
