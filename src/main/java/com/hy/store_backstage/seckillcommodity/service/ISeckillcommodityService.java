package com.hy.store_backstage.seckillcommodity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.commodity.entity.CommodityEntity;
import com.hy.store_backstage.seckillcommodity.entity.SeckillCommodityBo;
import com.hy.store_backstage.seckillcommodity.entity.Seckillcommodity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-10
 */
public interface ISeckillcommodityService extends IService<Seckillcommodity> {

    IPage<SeckillCommodityBo> queryAllSeckillCommodity(Integer seckillId, String comName, Integer currentPage, Integer pageSize);

    List<CommodityEntity> queryInCommodityId(String commodityId);

    ReturnJson deleteSeckillCommodity(Integer secComId);

    List<Seckillcommodity> addSeckillCommodity(@RequestBody List<SeckillCommodityBo> seckillCommodityBoList, Long seckillId);

}
