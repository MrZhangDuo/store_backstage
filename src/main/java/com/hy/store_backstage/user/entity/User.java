package com.hy.store_backstage.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Data
@TableName("user")
public class User implements Serializable {



    /**
     * 用户主键
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户密码
     */
    private String userPass;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户状态
     */
    private boolean userStatus=true;

    /**
     * 用户头像
     */
    private String userImg;

    @TableField(exist = false)
    private Set<String> roles;
    @TableField(exist = false)
    private Set<String> permissions;
}
