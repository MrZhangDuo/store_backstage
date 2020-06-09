package com.hy.store_backstage.permission.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Data
@TableName("permission")
public class Permission implements Serializable ,dataTree<Permission>{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父id
     */
    private Integer pid;

    private String name;

    private String purl;

    private String ptype;

    @TableField(exist = false)
    private List<Permission> children;



}







//    @TableId(value = "id", type = IdType.AUTO)
//    private Integer id;
//
//    private String lable;
//
//    private Integer pid;
//
//    private String purl;
//
//    private String ptype;
//
//    @TableField(exist = false)
//    private List<Permission> childList;
