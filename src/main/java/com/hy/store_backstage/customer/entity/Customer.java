package com.hy.store_backstage.customer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@TableName("customer")
@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户主键
     */
    @TableId(value = "cust_id", type = IdType.AUTO)
    private Long custId;

    /**
     * 客户账号
     */
    private String custAccount;

    /**
     * 客户昵称
     */
    private String custName;

    /**
     * 会员等级
     */
    private String vipGrade;

    /**
     * 账号状态
     */
    private String accountStatus;

    private LocalDate times;

}
