package com.hy.store_backstage.commodity.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.commodity.entity.AuditEntity;
import com.hy.store_backstage.commodity.entity.CommodityEntity;
import com.hy.store_backstage.commodity.mapper.CommodityMapper;
import com.hy.store_backstage.commodity.service.ICommodityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Service
@Transactional
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, CommodityEntity> implements ICommodityService {
  @Resource
   private CommodityMapper commodityMapper;

    /*查询商品的所有信息*/
    public IPage<CommodityEntity> selectPutInfo(Integer currentPage, Integer pageSize){
        return commodityMapper.selectPutInfo(new Page(currentPage,pageSize));
    };
    /*查询未上架商品的信息*/
    public IPage<CommodityEntity> selectOutInfo(Integer currentPage, Integer pageSize){
        return commodityMapper.selectOutInfo(new Page(currentPage,pageSize));
    };
    /*商品审核  查询待审核的商品信息*/
    public IPage<CommodityEntity> selectCheckCommodity(Integer currentPage, Integer pageSize){
        return commodityMapper.selectCheckCommodity(new Page(currentPage,pageSize));
    };
    /*查询审核通过商品的信息*/
    public IPage<CommodityEntity> selectPassInfo(Integer currentPage, Integer pageSize){
        return commodityMapper.selectPassInfo(new Page(currentPage,pageSize));
    };


    /*查询所有商品数量*/
    public Integer selectAllNum(){
       return  commodityMapper.selectAllNum();
    };
    /*查询以上架商品数量*/
    public Integer selectPutNum(){
        return commodityMapper.selectPutNum();
    };
    /*查询未下架商品数量*/
    public Integer selectOutNum(){
        return commodityMapper.selectOutNum();
    };
    /*查询待审核商品数量*/
    public Integer selectCheckNum(){
        return commodityMapper.selectCheckNum();
    };
    /*查询未通过商品数量*/
    public Integer selectNotPassNum(){
         return commodityMapper.selectNotPassNum();
    };
    /*商品列表中 根据条件模糊查询商品信息*/
    public IPage<CommodityEntity> selectLikeInfo(Integer currentPage, Integer pageSize,CommodityEntity commodityEntity){
        return commodityMapper.selectLikeInfo(new Page(currentPage,pageSize),commodityEntity);
    };

    /*模糊查询商品审核的信息*/
    public IPage<CommodityEntity> selectCheckInfo(Integer currentPage, Integer pageSize,CommodityEntity commodityEntity){
        return commodityMapper.selectCheckInfo(new Page(currentPage,pageSize),commodityEntity);
    };



    /*添加审核详情信息*/
    public void addAuditInfo(CommodityEntity  commodityEntity){
        Date date=new Date();
        System.out.println(date);
        commodityEntity.setaTime(date);
        commodityEntity.setaPerson("zhangsan");
        commodityMapper.addAuditInfo(commodityEntity);
    };

    /* 查询商品的审核状态，根据审核状态修改swich的值 */
    public Integer updateSwich(Integer comId){
        return commodityMapper.updateSwich(comId);
    };
    /*修改swich的值*/
    public void updateSwichValue(String comLabel,Integer comId){
        commodityMapper.updateSwichValue(comLabel,comId);
    };

    /*根据商品id查询商品的审核详情*/
    public List<AuditEntity>  selectAuditById(Integer comid){
       return commodityMapper.selectAuditById(comid);
    };

    /*222222222222222222222222222222222222222222222222222222222222222222222222222222222222222*/

    /*根据id查询商品的信息*/
    public CommodityEntity selectCommodityById(Integer comId){
        return commodityMapper.selectCommodityById(comId);
    };
    /*根据id查询商品的部分信息*/
    public CommodityEntity selectCommodity(Integer comId){
        return commodityMapper.selectCommodity(comId);
    };
    /*33333333333333333333333333333333333333333333333333333333333333333333333333333333333333333*/
    /*添加商品*/
    public void addCommodity(CommodityEntity commodityEntity){
        commodityMapper.addCommodity(commodityEntity);
    };

}

