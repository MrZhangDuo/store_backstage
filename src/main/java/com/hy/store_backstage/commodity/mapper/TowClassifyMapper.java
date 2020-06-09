package com.hy.store_backstage.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.store_backstage.commodity.entity.TwoClassifyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TowClassifyMapper extends BaseMapper<TwoClassifyEntity > {
    //   根据一级id查询二级分类的所有信息
    @Select("SELECT * FROM twoclassify WHERE one_id=#{value}")
    public List<TwoClassifyEntity> selectTwoClassify(Integer oneid);
}
