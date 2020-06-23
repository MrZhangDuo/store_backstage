package com.hy.store_backstage.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.commodity.entity.CommodityEntity;
import com.hy.store_backstage.commodity.entity.EvaluateFEntity;
import com.hy.store_backstage.commodity.entity.EvaluateSEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EvaluateFMapper extends BaseMapper<EvaluateFEntity>{
    /*根据父评论id查询下面所有的子评论信息*/
    @Select("SELECT s.*,f.eva_uesrname AS evaUesrname FROM evaluateson s,evaluatefather f WHERE s.eva_id=#{evaId} AND s.eva_id=f.eva_id ORDER BY son_isManage")
    public IPage<EvaluateSEntity> selectSonInfo(@Param("ipage") IPage<CommodityEntity> page,@Param("evaId") Integer evaId);

    /*添加管理员评论的信息*/
    @Insert("insert into evaluateson(son_person,son_time,son_content,eva_id,son_isManage,son_Email) values(#{sonPerson},#{sonTime},#{sonContent},#{evaId},#{sonIsManage},#{sonEmail})")
    public void addMassageInfo(EvaluateSEntity evaluateSEntity);

    /*查询父商品评价的条数*/
    @Select("select count(eva_id) from evaluatefather")
    public Integer countEva();

    /*查询父评论下子评论的数量*/
    @Select("select count(son_id) from evaluateson where eva_id=#{value} ")
    public Integer sonNumber(Integer evaId);

    /*根据商品名称或用户昵称模糊查询父评价*/
    @SelectProvider(type = UniteSelect.class ,method="selectPingjiaLike" )
    public IPage<EvaluateFEntity> selectPingjiaLike(@Param("ipage")IPage<CommodityEntity> page, @Param("evaluateFEntity")EvaluateFEntity evaluateFEntity);


}
