package com.hy.store_backstage.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.commodity.entity.AuditEntity;
import com.hy.store_backstage.commodity.entity.CommodityEntity;
import org.apache.ibatis.annotations.*;

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

    /*查询已上架商品的信息*/
    @Select("SELECT * FROM commodity WHERE com_label='上架'")
    public IPage<CommodityEntity> selectPutInfo(@Param("ipage") IPage<CommodityEntity> page);
    /*查询未上架商品的信息*/
    @Select("SELECT * FROM commodity WHERE com_label='未上架'")
    public IPage<CommodityEntity> selectOutInfo(@Param("ipage") IPage<CommodityEntity> page);
    /*商品审核  查询待审核的商品信息*/
    @Select("select * from commodity where com_state='2' and com_label='未上架'")
    public IPage<CommodityEntity> selectCheckCommodity(@Param("ipage") IPage<CommodityEntity> page);
    /*查询审核通过商品的信息*/
    @Select("SELECT * FROM commodity WHERE com_state='1'")
    public IPage<CommodityEntity> selectPassInfo(@Param("ipage") IPage<CommodityEntity> page);


    /*查询所有商品数量*/
    @Select("select count(com_id) from commodity")
    public Integer selectAllNum();
    /*查询上架商品数量*/
    @Select("select count(com_id) from commodity where com_label='上架'")
    public Integer selectPutNum();
    /*查询未上架商品数量*/
    @Select("select count(com_id) from commodity where com_label='未上架'")
    public Integer selectOutNum();
    /*查询待审核商品数量*/
    @Select("select count(com_id) from commodity where com_state='2' and com_label='未上架'")
    public Integer selectCheckNum();
    /*查询已通过商品数量*/
    @Select("select count(com_id) from commodity where com_state='1'")
    public Integer selectNotPassNum();

    /*商品列表中 根据条件模糊查询商品信息*/
    @SelectProvider(type = UniteSelect.class ,method="selectLike" )
    public IPage<CommodityEntity> selectLikeInfo(@Param("ipage")IPage<CommodityEntity> page,@Param("commodityEntity") CommodityEntity commodityEntity);

    /*模糊查询商品审核的信息*/
    @SelectProvider(type = UniteSelect.class ,method="selectCheckInfo" )
    public IPage<CommodityEntity> selectCheckInfo(@Param("ipage")IPage<CommodityEntity> page,@Param("commodityEntity") CommodityEntity commodityEntity);


    /*添加审核详情信息*/
    @Insert("insert into audit(com_id,com_state,com_detail,a_time,a_person) values(#{comId},#{comState},#{comDetail},#{aTime},#{aPerson})")
    public void addAuditInfo(CommodityEntity commodityEntity);
    /*根据商品id查询商品的审核详情*/
    @Select("select * from audit where com_id=#{value}")
    public List<AuditEntity> selectAuditById(Integer comid);

    /*222222222222222222222222222222222222222222222222222222222222222222222222222222222222222*/
    /* 查询商品的审核状态，根据审核状态修改swich的值 */
    @Select("SELECT com_state FROM commodity WHERE com_id=#{value}")
    public Integer updateSwich(Integer comId);
     /*修改swich的值*/
     @Update("Update commodity set com_label=#{comLabel} WHERE com_id=#{comId}")
     public void updateSwichValue(String comLabel,Integer comId);

    /*根据id查询商品的信息*/
    @Select("select * from commodity where com_id=#{value}")
    public CommodityEntity selectCommodityById(Integer comId);

    /*根据id查询商品的部分信息*/
    @Select("select com_id,com_name,com_brand from commodity where com_id=#{value}")
    public CommodityEntity selectCommodity(Integer comId);

    /*33333333333333333333333333333333333333333333333333333333333333333333333333333333333333333*/
    /*添加商品*/
    @Insert("insert into commodity(com_name,com_brand,com_no) values(#{comName},#{comBrand},#{comNo})")
    public void addCommodity(CommodityEntity commodityEntity);


}
