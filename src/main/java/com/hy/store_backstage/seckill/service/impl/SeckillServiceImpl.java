package com.hy.store_backstage.seckill.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.store_backstage.seckill.entity.Seckill;
import com.hy.store_backstage.seckill.entity.bo.SeckillBo;
import com.hy.store_backstage.seckill.mapper.SeckillMapper;
import com.hy.store_backstage.seckill.service.ISeckillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-05
 */
@Service
public class SeckillServiceImpl extends ServiceImpl<SeckillMapper, Seckill> implements ISeckillService {
    @Autowired
    SeckillMapper seckillMapper;

    @Override
    public IPage<SeckillBo> queryAllSeckill(SeckillBo seckillBo, Integer currentPage, Integer pageSize) {
        return this.seckillMapper.queryAllSeckill(new Page(currentPage,pageSize),seckillBo);
    }
}
