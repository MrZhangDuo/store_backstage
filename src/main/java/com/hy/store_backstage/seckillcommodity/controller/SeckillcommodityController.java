package com.hy.store_backstage.seckillcommodity.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hy.store_backstage.commodity.entity.CommodityEntity;
import com.hy.store_backstage.seckill.entity.bo.SeckillBo;
import com.hy.store_backstage.seckillcommodity.entity.SeckillCommodityBo;
import com.hy.store_backstage.seckillcommodity.entity.Seckillcommodity;
import com.hy.store_backstage.seckillcommodity.service.impl.SeckillcommodityServiceImpl;
import com.hy.store_backstage.utils.ReturnJson;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import javafx.scene.control.Tab;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
     * @Description //TODO 
     * @Date 13:55 2020/6/11
     * @Param [seckillId]
     * @return java.util.List<com.hy.store_backstage.seckillcommodity.entity.SeckillCommodityBo>
     **/
    @CrossOrigin
    @RequestMapping("queryAllSeckillCommodity")
    public IPage<SeckillCommodityBo> queryAllSeckillCommodity(Integer seckillId, String comName, Integer currentPage, Integer pageSize) {
        return seckillcommodityService.queryAllSeckillCommodity(seckillId,comName,currentPage,pageSize);
    }

    @CrossOrigin
    @RequestMapping("queryInCommodityId")
    public List<CommodityEntity> queryInCommodityId(String commodityId) {
        return seckillcommodityService.queryInCommodityId(commodityId);
    }

    @CrossOrigin
    @RequestMapping("deleteSeckillCommodity")
    public ReturnJson deleteSeckillCommodity(Integer secComId) {
        return seckillcommodityService.deleteSeckillCommodity(secComId);
    }

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






