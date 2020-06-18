package com.hy.store_backstage.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.store_backstage.commodity.entity.ColorEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ColorMapper extends BaseMapper<ColorEntity> {
    /*查询所有的颜色*/
    @Select("select * from colors")
    public List<ColorEntity> selectAllColor();
    /*添加商品颜色*/
    @Insert("insert into colors(color_id,color_name) values(#{colorId},#{colorName}) ")
    public void addColor(ColorEntity colorEntity);

}
