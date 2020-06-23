package com.hy.store_backstage.commodity.service;

import com.hy.store_backstage.commodity.entity.ColorEntity;
import com.hy.store_backstage.commodity.entity.SizeEntity;

import java.util.List;

public interface ISizeAndColorService {
    /*查询所有的颜色*/
    public List<ColorEntity> selectAllColor();
    /*查询所有的尺寸大小*/
    public List<SizeEntity> selectAllSize();
    /*添加商品尺寸*/
    public void addSize(SizeEntity sizeEntity);
    /*添加商品颜色*/
    public void   addColor(ColorEntity colorEntity);
//    /*删除选中的多选框 尺寸*/
//    public void delSize(String sizeName);
}
