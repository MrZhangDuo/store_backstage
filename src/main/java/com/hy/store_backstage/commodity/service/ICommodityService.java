package com.hy.store_backstage.commodity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.store_backstage.commodity.entity.AuditEntity;
import com.hy.store_backstage.commodity.entity.CommodityEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
public interface ICommodityService extends IService<CommodityEntity> {
    /*查询商品的所有信息*/
    public IPage<CommodityEntity> selectPutInfo(Integer currentPage, Integer pageSize);
    /*查询未上架商品的信息*/
    public IPage<CommodityEntity> selectOutInfo(Integer currentPage, Integer pageSize);
    /*商品审核  查询待审核的商品信息*/
    public IPage<CommodityEntity> selectCheckCommodity(Integer currentPage, Integer pageSize);
    /*查询审核通过商品的信息*/
    public IPage<CommodityEntity> selectPassInfo(Integer currentPage, Integer pageSize);

    /*查询所有商品数量*/
    public Integer selectAllNum();

    /*查询以上架商品数量*/
    public Integer selectPutNum();

    /*查询未下架商品数量*/
    public Integer selectOutNum();

    /*查询待审核商品数量*/
    public Integer selectCheckNum();

    /*查询未通过商品数量*/
    public Integer selectNotPassNum();

    /*商品列表中 根据条件模糊查询商品信息*/
    public IPage<CommodityEntity> selectLikeInfo(Integer currentPage, Integer pageSize,CommodityEntity commodityEntity);

    /*模糊查询商品审核的信息*/
    public IPage<CommodityEntity> selectCheckInfo(Integer currentPage, Integer pageSize,CommodityEntity commodityEntity);

    /*添加审核详情信息*/
    public void addAuditInfo(CommodityEntity commodityEntity);

    /*根据商品id查询商品的审核详情*/
    public List<AuditEntity> selectAuditById(Integer comid);

    /*根据id查询商品的部分信息*/
    public CommodityEntity selectCommodity(Integer comId);

    /* 查询商品的审核状态，根据审核状态修改swich的值 */
    public Integer updateSwich(Integer comId);
    /*修改swich的值*/
    public void updateSwichValue(String comLabel,Integer comId);

    /*根据id查询商品的信息*/
    public CommodityEntity selectCommodityById(Integer comId);

    /*33333333333333333333333333333333333333333333333333333333333333333333333333333333333333333*/
    /*添加商品*/
    public void addCommodity(CommodityEntity commodityEntity);
}
