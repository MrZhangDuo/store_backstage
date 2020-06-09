package com.hy.store_backstage.commodity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.commodity.entity.AuditEntity;
import com.hy.store_backstage.commodity.entity.CommodityEntity;
import com.hy.store_backstage.commodity.entity.OneClassifyEntity;
import com.hy.store_backstage.commodity.entity.TwoClassifyEntity;
import com.hy.store_backstage.commodity.mapper.CommodityMapper;
import com.hy.store_backstage.commodity.mapper.OneClassifyMapper;
import com.hy.store_backstage.commodity.mapper.TowClassifyMapper;
import com.hy.store_backstage.commodity.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
  @Autowired
   private CommodityMapper commodityMapper;
  @Autowired
   private OneClassifyMapper oneClassifyMapper;
  @Autowired
   private TowClassifyMapper towClassifyMapper;
    /*查询商品的所有信息*/
//    public List<CommodityEntity> selectCommodityInfo(Integer currentPage, Integer pageSize){
//        Page page= PageHelper.startPage(currentPage,pageSize,true);
//        return commodityMapper.selectCommodityInfo();
//    };
    public List<CommodityEntity> selectCommodityInfo(){
        return commodityMapper.selectCommodityInfo();
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
    public List<CommodityEntity> selectLikeInfo(CommodityEntity commodityEntity){
        return commodityMapper.selectLikeInfo(commodityEntity);
    };


    /*添加审核详情信息*/
    public void addAuditInfo(CommodityEntity  commodityEntity){
        Date date=new Date();
        System.out.println(date);
        commodityEntity.setaTime(date);
        commodityEntity.setaPerson("zhangsan");
        commodityMapper.addAuditInfo(commodityEntity);
    };
    /*根据商品id查询商品的审核详情*/
    public List<AuditEntity>  selectAuditById(Integer comid){
       return commodityMapper.selectAuditById(comid);
    };
 /*222222222222222222222222222222222222222222222222222222222222222222222222222222222222222*/
     // 查询一级分类的所有信息
     public List<OneClassifyEntity>  selectOneClassify(){
        return oneClassifyMapper.selectOneClassify();
     };

    //   根据一级id查询二级分类的所有信息
    public List<TwoClassifyEntity>  selectTwoClassify(Integer oneid){
       return towClassifyMapper.selectTwoClassify(oneid);
    };
    /*333333333333333333333333333333333333333333333333333333333333333333*/
    /*商品审核  查询待审核的商品数量*/
    public List<CommodityEntity> selectCheckCommodity(){
        return commodityMapper.selectCheckCommodity();
    };
    /*根据id查询商品的信息*/
    public CommodityEntity selectCommodityById(Integer comId){
        return commodityMapper.selectCommodityById(comId);
    };
}
