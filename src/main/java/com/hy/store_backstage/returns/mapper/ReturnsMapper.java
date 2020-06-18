package com.hy.store_backstage.returns.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.returns.entity.Returns;
import com.hy.store_backstage.returns.entity.ReturnsCommodityBo;
import com.hy.store_backstage.returns.provider.SelectProviders;
import com.hy.store_backstage.returns.provider.UpdateProviders;
import com.hy.store_backstage.seckill.entity.bo.SeckillBo;
import com.hy.store_backstage.utils.ReturnJson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Mapper
public interface ReturnsMapper extends BaseMapper<Returns> {

    @SelectProvider(type = SelectProviders.class,method = "queryAllOrders")
    IPage<ReturnsCommodityBo> queryAllReturns(@Param("page")IPage<Returns> page , @Param("returns")Returns returns);

    @UpdateProvider(type = UpdateProviders.class,method = "examine")
    Integer examine(Long returnId,String applyforStatus);

}
