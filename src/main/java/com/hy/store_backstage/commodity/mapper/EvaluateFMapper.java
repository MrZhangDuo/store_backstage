package com.hy.store_backstage.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.store_backstage.commodity.entity.EvaluateFEntity;
import com.hy.store_backstage.commodity.entity.EvaluateSEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface EvaluateFMapper extends BaseMapper<EvaluateFEntity>{
    /*根据父评论id查询下面所有的子评论*/
    @Select("SELECT s.*,f.eva_uesrname AS evaUesrname FROM evaluateson s,evaluatefather f WHERE s.eva_id=#{value} AND s.eva_id=f.eva_id ORDER BY son_isManage")
    public List<EvaluateSEntity> selectSonInfo(Integer evaId);

    /*添加管理员评论的信息*/
    @Insert("insert into evaluateson(son_person,son_time,son_content,eva_id,son_isManage,son_Email) values(#{sonPerson},#{sonTime},#{sonContent},#{evaId},#{sonIsManage},#{sonEmail})")
    public void addMassageInfo(EvaluateSEntity evaluateSEntity);

    /*根据商品名称或用户昵称模糊查询父评价*/
    @SelectProvider(type = UniteSelect.class ,method="selectPingjiaLike" )
    public List<EvaluateFEntity> selectPingjiaLike(EvaluateFEntity evaluateFEntity);
}
