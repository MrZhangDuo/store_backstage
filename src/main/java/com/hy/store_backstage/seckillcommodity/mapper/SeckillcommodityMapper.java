package com.hy.store_backstage.seckillcommodity.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.commodity.entity.CommodityEntity;
import com.hy.store_backstage.seckill.entity.bo.SeckillBo;
import com.hy.store_backstage.seckillcommodity.Providers.QueryAllSeckillCommodity;
import com.hy.store_backstage.seckillcommodity.entity.SeckillCommodityBo;
import com.hy.store_backstage.seckillcommodity.entity.Seckillcommodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import javax.management.Query;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-10
 */
@Mapper
public interface SeckillcommodityMapper extends BaseMapper<Seckillcommodity> {

    @SelectProvider(type = QueryAllSeckillCommodity.class,method = "queryAllSeckillCommodity")
    IPage<SeckillCommodityBo> queryAllSeckillCommodity(IPage<SeckillBo> page,@Param("seckillId")Integer seckillId, @Param("comName")String comName);

    @SelectProvider(type = QueryAllSeckillCommodity.class,method = "queryInCommodityId")
    List<CommodityEntity> queryInCommodityId(String commodityId);

}
