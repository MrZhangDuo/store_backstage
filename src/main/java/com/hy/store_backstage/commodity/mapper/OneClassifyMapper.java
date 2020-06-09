package com.hy.store_backstage.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.store_backstage.commodity.entity.OneClassifyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OneClassifyMapper extends BaseMapper<OneClassifyEntity> {
  // 查询一级分类的所有信息
    @Select("select * from oneclassify")
    public List<OneClassifyEntity>  selectOneClassify();

}
