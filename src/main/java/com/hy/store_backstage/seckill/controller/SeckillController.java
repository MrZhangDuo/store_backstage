package com.hy.store_backstage.seckill.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.seckill.entity.bo.SeckillBo;
import com.hy.store_backstage.seckill.service.impl.SeckillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public IPage<SeckillBo> queryAllSeckill(SeckillBo seckillBo, Integer currentPage, Integer pageSize) {
        return this.seckillService.queryAllSeckill(seckillBo,currentPage,pageSize);
    }

}
