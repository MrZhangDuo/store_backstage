package com.hy.store_backstage.permission.entity;

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
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "perid", type = IdType.AUTO)
    private Integer perid;

    /**
     * 父id
     */
    private Integer pid;

    private String pername;

    private String percode;

    private String purl;

    /**
     * 排序码
     */
    private Integer ordernumber;

    /**
     * 权限类型
     */
    private String ptype;

    /**
     * 是否可用
     */
    private String available;

    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }
    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode;
    }
    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }
    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }
    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Permission{" +
        "perid=" + perid +
        ", pid=" + pid +
        ", pername=" + pername +
        ", percode=" + percode +
        ", purl=" + purl +
        ", ordernumber=" + ordernumber +
        ", ptype=" + ptype +
        ", available=" + available +
        "}";
    }
}
