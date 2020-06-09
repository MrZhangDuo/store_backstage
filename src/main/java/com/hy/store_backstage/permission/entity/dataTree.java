package com.hy.store_backstage.permission.entity;

import lombok.Data;

import java.util.List;

/**
 * @ClassName dataTree
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/8 0:07
 * @Version 1.0
 */
public interface dataTree<T> {

    public Integer getId();

    public Integer getPid();

    public String getName();

    public void setChildren(List<T> children);

    public List<T> getChildren();

}

