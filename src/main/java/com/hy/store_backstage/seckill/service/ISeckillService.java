package com.hy.store_backstage.seckill.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.seckill.entity.Seckill;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.store_backstage.seckill.entity.bo.SeckillBo;
import com.hy.store_backstage.utils.ReturnJson;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-05
 */
public interface ISeckillService extends IService<Seckill> {

    IPage<SeckillBo> queryAllSeckill(SeckillBo seckillBo, Integer currentPage, Integer pageSize,String startTimes,String endTimes);

    Seckill querySeckillById(Long seckillId);

    ReturnJson updateSeckillById(Seckill seckill,String startTimes,String endTimes);

    ReturnJson deleteSeckillById(Long seckillId);

    ReturnJson addSeckill(Seckill seckill,String startTimes,String endTimes);

}
