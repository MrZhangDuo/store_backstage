package com.hy.store_backstage.seckillcommodity.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.commodity.entity.CommodityEntity;
import com.hy.store_backstage.seckillcommodity.entity.SeckillCommodityBo;
import com.hy.store_backstage.seckillcommodity.entity.Seckillcommodity;
import com.hy.store_backstage.seckillcommodity.service.impl.SeckillcommodityServiceImpl;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/seckillcommodity")
@Transactional
public class SeckillcommodityController {
    @Autowired
    SeckillcommodityServiceImpl seckillcommodityService;

    /**
     * @Author zhangduo
     * @Description //TODO 查询某个活动下的所有秒杀商品
     * @Date 10:26 2020/6/17
     * @Param [seckillId, comName, currentPage, pageSize]
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.hy.store_backstage.seckillcommodity.entity.SeckillCommodityBo>
     **/
    @CrossOrigin
    @RequestMapping("queryAllSeckillCommodity")
    public IPage<SeckillCommodityBo> queryAllSeckillCommodity(Integer seckillId, String comName, Integer currentPage, Integer pageSize) {
        return seckillcommodityService.queryAllSeckillCommodity(seckillId,comName,currentPage,pageSize);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 查询多个商品
     * @Date 10:30 2020/6/17
     * @Param [commodityId]
     * @return java.util.List<com.hy.store_backstage.commodity.entity.CommodityEntity>
     **/
    @CrossOrigin
    @RequestMapping("queryInCommodityId")
    public List<CommodityEntity> queryInCommodityId(String commodityId) {
        return seckillcommodityService.queryInCommodityId(commodityId);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 删除某个活动下的秒杀商品
     * @Date 10:26 2020/6/17
     * @Param [secComId]
     * @return com.hy.store_backstage.utils.ReturnJson
     **/
    @CrossOrigin
    @RequestMapping("deleteSeckillCommodity")
    public ReturnJson deleteSeckillCommodity(Integer secComId) {
        return seckillcommodityService.deleteSeckillCommodity(secComId);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 给某个活动添加秒杀商品
     * @Date 10:27 2020/6/17
     * @Param [seckillCommodityBoList, seckillId]
     * @return com.hy.store_backstage.utils.ReturnJson
     **/
    @CrossOrigin
    @RequestMapping(value = "addSeckillCommodity", method = RequestMethod.POST)
    public ReturnJson addSeckillCommodity(@RequestBody List<SeckillCommodityBo> seckillCommodityBoList, Long seckillId) {
        List<Seckillcommodity> seckillcommodityList = seckillcommodityService.addSeckillCommodity(seckillCommodityBoList,seckillId);
        Boolean returns = seckillcommodityService.saveBatch(seckillcommodityList,seckillcommodityList.size());
        if(returns){
            return new ReturnJson(200,"添加活动商品成功");
        }else{
            return new ReturnJson(200,"添加活动商品失败");
        }
    }

}






