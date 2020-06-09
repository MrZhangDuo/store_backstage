package com.hy.store_backstage.commodity.controller;

import com.hy.store_backstage.commodity.entity.AuditEntity;
import com.hy.store_backstage.commodity.entity.CommodityEntity;
import com.hy.store_backstage.commodity.entity.OneClassifyEntity;
import com.hy.store_backstage.commodity.entity.TwoClassifyEntity;
import com.hy.store_backstage.commodity.service.impl.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityServiceImpl commodityService;


    /*查询商品的所有信息*/
//    @RequestMapping("/selectCommodityInfo.do")
//    @ResponseBody
//    public Pages selectCommodityInfo(@RequestParam(value = "page", defaultValue = "1")Integer page, @RequestParam(value = "limit", defaultValue = "3")Integer limit){
//        List<CommodityEntity> page1 = commodityService.selectCommodityInfo(page,limit);
//        PageInfo pageInfo = new PageInfo(page1);
//
//        Pages pages = new Pages();
//        pages.setCode(0);
//        pages.setCount(Integer.parseInt(String.valueOf(pageInfo.getTotal())));/*Count数据总条数*/
//        pages.setMsg("");
//        pages.setData(pageInfo.getList());/*数据信息*/
//        return pages;
//    };
    @RequestMapping("/selectCommodityInfo.do")
    @ResponseBody
    @CrossOrigin
    public List<CommodityEntity> selectCommodityInfo(){
       return  commodityService.selectCommodityInfo();
    };


    /*查询所有商品数量*/
    @RequestMapping("/selectAllNum.do")
    @ResponseBody
    @CrossOrigin
    public Integer selectAllNum(){
        return  commodityService.selectAllNum();
    };

    /*查询已上架商品数量*/
    @RequestMapping("/selectPutNum.do")
    @ResponseBody
    @CrossOrigin
    public Integer selectPutNum(){
        return commodityService.selectPutNum();
    };

    /*查询已下架商品数量*/
    @RequestMapping("/selectOutNum.do")
    @ResponseBody
    @CrossOrigin
    public Integer selectOutNum(){
        return commodityService.selectOutNum();
    };

    /*查询待审核商品数量*/
    @RequestMapping("/selectCheckNum.do")
    @ResponseBody
    @CrossOrigin
    public Integer selectCheckNum(){
        return commodityService.selectCheckNum();
    };

    /*查询未通过商品数量*/
    @RequestMapping("/selectNotPassNum.do")
    @ResponseBody
    @CrossOrigin
    public Integer selectNotPassNum(){
        return commodityService.selectNotPassNum();
    };

    /*修改商品标签状态*/
    @RequestMapping("/updateLable.do")
    @ResponseBody
    @CrossOrigin
    public void updateLable(CommodityEntity commodity){
        commodityService.updateById(commodity);
    };
    /*删除商品*/
    @RequestMapping("/deleteCom.do")
    @ResponseBody
    @CrossOrigin
    public void deleteCom(Long cid){
        commodityService.removeById(cid);
    };

    /*商品列表中 根据条件模糊查询商品信息*/
    @RequestMapping("/selectLikeInfo.do")
    @ResponseBody
    @CrossOrigin
    public List<CommodityEntity> selectLikeInfo(CommodityEntity commodityEntity){
        return commodityService.selectLikeInfo(commodityEntity);
    };
/*222222222222222222222222222222222222222222222222222222222222222222222222222222222222*/
    // 查询一级分类的所有信息
    @RequestMapping("/selectOneClassify.do")
    @ResponseBody
    @CrossOrigin
    public List<OneClassifyEntity>  selectOneClassify(){
        return commodityService.selectOneClassify();
    };

    //   根据一级id查询二级分类的所有信息
    @RequestMapping("/selectTwoClassify.do")
    @ResponseBody
    @CrossOrigin
    public List<TwoClassifyEntity>  selectTwoClassify(Integer oneid){
        return commodityService.selectTwoClassify(oneid);
    };

    /*33333333333333333333333333333333333333333333333333333333333333333333333333*/
    /*商品审核  查询待审核的商品数量*/
    @RequestMapping("/selectCheckCommodity.do")
    @ResponseBody
    @CrossOrigin
    public List<CommodityEntity> selectCheckCommodity(){
        return commodityService.selectCheckCommodity();
    };
    /*根据id查询商品的信息*/
    @RequestMapping("/selectCommodityById.do")
    @ResponseBody
    @CrossOrigin
    public CommodityEntity selectCommodityById(Integer comId){
        return commodityService.selectCommodityById(comId);
    };

    /* 审核商品并添加一条审核详情信息*/
    @RequestMapping("/updateCheckCommodity.do")
    @ResponseBody
    @CrossOrigin
    public void updateCheckCommodity(CommodityEntity commodityEntity){
        commodityService.updateById(commodityEntity);
        commodityService.addAuditInfo(commodityEntity);
    }
    /*根据商品id查询商品的审核详情*/
    @RequestMapping("/selectAuditById.do")
    @ResponseBody
    @CrossOrigin
    public List<AuditEntity>  selectAuditById(Integer comId){
        return commodityService.selectAuditById(comId);
    };
}
