package com.hy.store_backstage.commodity.controller;

import com.hy.store_backstage.commodity.entity.AuditEntity;
import com.hy.store_backstage.commodity.entity.ComAndReper;
import com.hy.store_backstage.commodity.entity.CommodityEntity;
import com.hy.store_backstage.commodity.mapper.CommodityMapper;
import com.hy.store_backstage.commodity.service.impl.CommodityServiceImpl;
import com.hy.store_backstage.commodity.service.impl.RepertoryService;
import com.hy.store_backstage.commodity.service.impl.SizeAndColorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
    @Resource
    private CommodityMapper commodity;
    @Autowired
    private SizeAndColorServiceImpl sizeAndColorService;
    @Autowired
    private RepertoryService repertoryService;

   /*查询商品的所有信息*/
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
    /*33333333333333333333333333333333333333333333333333333333333333333333333333*/
    /*商品审核  查询待审核的商品信息*/
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

    /*33333333333333333333333333333333333333333333333333333333333333333333333333333333333333333*/
    /*添加商品*/
    @PostMapping("/addCommodity.do")
    @ResponseBody
    @CrossOrigin
    public void addCommodity(@RequestBody ComAndReper json){
        Long repertoryNumber=0L;
        LocalDateTime data=LocalDateTime.now();

        String image=json.getSizeAndColors().get(0).getComImg();
        System.out.println("获取的图片地址"+image);
        Double money=json.getSizeAndColors().get(0).getComPrice();//获取库存中的价格
        json.getCommodity().setComPrice(money);//将获取的价格添加到商品表中
        json.getCommodity().setComStock(repertoryNumber);//总库存
        json.getCommodity().setComNo(repertoryService.bianma());//设置编码
        int returs = commodity.insert(json.getCommodity()); /*添加商品信息并返回该商品的id*/
        for (int i = 0; i < json.getSizeAndColors().size(); i++) {
            // 商品总库存
            repertoryNumber+=json.getSizeAndColors().get(i).getRepertoryNumber();
            // 库存SKU编号
            json.getSizeAndColors().get(i).setComSku(UUID.randomUUID().toString().replace("-", "").toLowerCase());
            json.getSizeAndColors().get(i).setDifferBoth(1);//区分出库与入库   1为入库   2为出库
            json.getSizeAndColors().get(i).setHandleType("添加商品");
            json.getSizeAndColors().get(i).setGooutTime(data);  //商品入库时间
            json.getSizeAndColors().get(i).setGooutPerson("hanhan"); //添加商品的人（当前登录人）
            json.getSizeAndColors().get(i).setComId(json.getCommodity().getComId());
        }
        repertoryService.saveBatch(json.getSizeAndColors(),json.getSizeAndColors().size());
    };


}
