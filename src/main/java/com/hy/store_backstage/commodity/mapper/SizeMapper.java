package com.hy.store_backstage.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.store_backstage.commodity.entity.SizeEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SizeMapper extends BaseMapper<SizeEntity> {
    /*查询所有的尺寸大小*/
    @Select("select * from size")
    public List<SizeEntity> selectAllSize();

    /*添加商品尺寸*/
    @Insert("insert into size(size_id,size_name) values(#{sizeId},#{sizeName})")
    public void addSize(SizeEntity sizeEntity);

//    /*删除选中的多选框 尺寸*/
//    @Delete("delete from size where size_name=#{value}")
//    public void delSize(String sizeName);
}
