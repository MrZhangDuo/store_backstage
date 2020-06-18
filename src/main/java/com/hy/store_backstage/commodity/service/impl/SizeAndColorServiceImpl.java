package com.hy.store_backstage.commodity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.commodity.entity.ColorEntity;
import com.hy.store_backstage.commodity.entity.SizeEntity;
import com.hy.store_backstage.commodity.mapper.ColorMapper;
import com.hy.store_backstage.commodity.mapper.SizeMapper;
import com.hy.store_backstage.commodity.service.ISizeAndColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SizeAndColorServiceImpl extends ServiceImpl<SizeMapper, SizeEntity> implements ISizeAndColorService  {
   @Autowired
    private SizeMapper sizeMapper;
   @Autowired
   private ColorMapper colorMapper;

    /*查询所有的颜色*/
    public List<ColorEntity> selectAllColor(){
        return colorMapper.selectAllColor();
    };
    /*查询所有的尺寸大小*/
    public List<SizeEntity> selectAllSize(){
        return sizeMapper.selectAllSize();
    };

    /*添加商品尺寸*/
    public void addSize(SizeEntity sizeEntity){
        sizeMapper.addSize(sizeEntity);
    };
    /*添加商品颜色*/
    public void addColor(ColorEntity colorEntity){
         colorMapper.addColor(colorEntity);
    };

    /*删除选中的多选框 尺寸*/
//    public void delSize(String sizeName){
//        sizeMapper.delSize(sizeName);
//    };
}
