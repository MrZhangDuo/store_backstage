package com.hy.store_backstage.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.store_backstage.commodity.entity.AuditEntity;
import com.hy.store_backstage.commodity.entity.CommodityEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Mapper
public interface CommodityMapper extends BaseMapper<CommodityEntity> {

    /*查询商品的所有信息*/
    @Select("SELECT * FROM commodity")
    public List<CommodityEntity> selectCommodityInfo();
    /*查询所有商品数量*/
    @Select("select count(com_id) from commodity")
    public Integer selectAllNum();
    /*查询以上架商品数量*/
    @Select("select count(com_id) from commodity where com_label='上架'")
    public Integer selectPutNum();
    /*查询未上架商品数量*/
    @Select("select count(com_id) from commodity where com_label='未上架'")
    public Integer selectOutNum();
    /*商品列表中 根据条件模糊查询商品信息*/
    @SelectProvider(type = UniteSelect.class ,method="selectLike" )
    public List<CommodityEntity> selectLikeInfo(CommodityEntity commodityEntity);


    /*查询待审核商品数量*/
    @Select("select count(com_id) from commodity where com_state='2'")
    public Integer selectCheckNum();
    /*查询已通过商品数量*/
    @Select("select count(com_id) from commodity where com_state='1'")
    public Integer selectNotPassNum();
    /*添加审核详情信息*/
    @Insert("insert into audit(com_id,com_state,com_detail,a_time,a_person) values(#{comId},#{comState},#{comDetail},#{aTime},#{aPerson})")
    public void addAuditInfo(CommodityEntity commodityEntity);
    /*根据商品id查询商品的审核详情*/
    @Select("select * from audit where com_id=#{value}")
    public List<AuditEntity> selectAuditById(Integer comid);

/*3333333333333333333333333333333333333333333333333333333333333333333333333333*/
    /*商品审核  查询待审核的商品信息*/
    @Select("select * from commodity where com_state='2' and com_label='上架'")
    public List<CommodityEntity> selectCheckCommodity();
    /*根据id查询商品的信息*/
    @Select("select * from commodity where com_id=#{value}")
    public CommodityEntity selectCommodityById(Integer comId);



}
