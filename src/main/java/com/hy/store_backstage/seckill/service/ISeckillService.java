package com.hy.store_backstage.seckill.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.seckill.entity.Seckill;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.store_backstage.seckill.entity.bo.SeckillBo;

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

    IPage<SeckillBo> queryAllSeckill(SeckillBo seckillBo, Integer currentPage, Integer pageSize);

}
