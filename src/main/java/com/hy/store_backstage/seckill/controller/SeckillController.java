package com.hy.store_backstage.seckill.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.seckill.entity.Seckill;
import com.hy.store_backstage.seckill.entity.bo.SeckillBo;
import com.hy.store_backstage.seckill.service.impl.SeckillServiceImpl;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    /**
     * @Author zhangduo
     * @Description //TODO 查询所有的秒杀活动
     * @Date 10:22 2020/6/17
     * @Param [seckillBo, currentPage, pageSize, startTimes, endTimes]
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.hy.store_backstage.seckill.entity.bo.SeckillBo>
     **/
    @CrossOrigin
    @RequestMapping(value = "queryAllSeckill",method = RequestMethod.GET)
    public IPage<SeckillBo> queryAllSeckill(SeckillBo seckillBo, Integer currentPage, Integer pageSize,String startTimes,String endTimes) {
        return this.seckillService.queryAllSeckill(seckillBo,currentPage,pageSize,startTimes,endTimes);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 查询某个秒杀活动
     * @Date 10:23 2020/6/17
     * @Param [seckillId]
     * @return com.hy.store_backstage.seckill.entity.Seckill
     **/
    @CrossOrigin
    @RequestMapping(value = "querySeckillById",method = RequestMethod.GET)
    public Seckill querySeckillById(Long seckillId) {
        return seckillService.querySeckillById(seckillId);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 编辑某个秒杀活动
     * @Date 10:23 2020/6/17
     * @Param [seckill, startTimes, endTimes]
     * @return com.hy.store_backstage.utils.ReturnJson
     **/
    @CrossOrigin
    @RequestMapping(value = "updateSeckillById",method = RequestMethod.GET)
    public ReturnJson updateSeckillById(Seckill seckill,String startTimes,String endTimes) {
        return seckillService.updateSeckillById(seckill,startTimes,endTimes);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 删除某个秒杀活动
     * @Date 10:23 2020/6/17
     * @Param [seckillId]
     * @return com.hy.store_backstage.utils.ReturnJson
     **/
    @CrossOrigin
    @RequestMapping(value = "deleteSeckillById",method = RequestMethod.GET)
    public ReturnJson deleteSeckillById(Long seckillId) {
        return seckillService.deleteSeckillById(seckillId);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 添加某个秒杀活动
     * @Date 10:23 2020/6/17
     * @Param [seckill, startTimes, endTimes]
     * @return com.hy.store_backstage.utils.ReturnJson
     **/
    @CrossOrigin
    @RequestMapping(value = "addSeckill",method = RequestMethod.GET)
    public ReturnJson addSeckill(Seckill seckill,String startTimes,String endTimes) {
        return seckillService.addSeckill(seckill,startTimes,endTimes);
    }



}
