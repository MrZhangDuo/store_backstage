package com.hy.store_backstage.seckill.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.seckill.entity.Seckill;
import com.hy.store_backstage.seckill.entity.bo.SeckillBo;
import com.hy.store_backstage.seckill.service.impl.SeckillServiceImpl;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-05
 */
@RestController
@RequestMapping("/seckill")
@Transactional
public class SeckillController {
    @Autowired
    SeckillServiceImpl seckillService;

    @CrossOrigin
    @RequestMapping(value = "queryAllSeckill",method = RequestMethod.GET)
    public IPage<SeckillBo> queryAllSeckill(SeckillBo seckillBo, Integer currentPage, Integer pageSize,String startTimes,String endTimes) {
        return this.seckillService.queryAllSeckill(seckillBo,currentPage,pageSize,startTimes,endTimes);
    }


    @CrossOrigin
    @RequestMapping(value = "querySeckillById",method = RequestMethod.GET)
    public Seckill querySeckillById(Long seckillId) {
        return seckillService.querySeckillById(seckillId);
    }

    @CrossOrigin
    @RequestMapping(value = "updateSeckillById",method = RequestMethod.GET)
    public ReturnJson updateSeckillById(Seckill seckill,String startTimes,String endTimes) {
        return seckillService.updateSeckillById(seckill,startTimes,endTimes);
    }

    @CrossOrigin
    @RequestMapping(value = "deleteSeckillById",method = RequestMethod.GET)
    public ReturnJson deleteSeckillById(Long seckillId) {
        return seckillService.deleteSeckillById(seckillId);
    }

    @CrossOrigin
    @RequestMapping(value = "addSeckill",method = RequestMethod.GET)
    public ReturnJson addSeckill(Seckill seckill,String startTimes,String endTimes) {
        return seckillService.addSeckill(seckill,startTimes,endTimes);
    }



}
