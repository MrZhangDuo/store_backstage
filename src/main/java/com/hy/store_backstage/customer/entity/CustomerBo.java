package com.hy.store_backstage.customer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * @ClassName CustomerBo
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/15 14:48
 * @Version 1.0
 */
@Data
public class CustomerBo {
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

    private Double orderMony;

    private Long orderCount;

    private String zcTimes;

    private Integer currentPage;

    private Integer pageSize;


}
