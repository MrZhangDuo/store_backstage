package com.hy.store_backstage.seckill.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.seckill.Providers.QueryAllSeckill;
import com.hy.store_backstage.seckill.entity.Seckill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.store_backstage.seckill.entity.bo.SeckillBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-05
 */
@Mapper
public interface SeckillMapper extends BaseMapper<Seckill> {

    @SelectProvider(type = QueryAllSeckill.class,method = "queryAllSeckill")
    IPage<SeckillBo> queryAllSeckill(@Param("ipage")IPage<SeckillBo> page , @Param("seckillBo")SeckillBo seckillBo);

}
