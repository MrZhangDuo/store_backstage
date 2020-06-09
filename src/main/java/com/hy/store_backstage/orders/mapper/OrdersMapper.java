package com.hy.store_backstage.orders.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.store_backstage.orders.Providers.select.queryAllOrders;
import com.hy.store_backstage.orders.entity.Orders;
import com.hy.store_backstage.orders.entity.bo.OrdersCommodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    /**
     * @Author zhangduo
     * @Description //TODO 查询所有订单
     * @Date 19:47 2020/6/4
     * @Param
     * @return List<OrdersCommodity>
     **/
    @SelectProvider(type = queryAllOrders.class, method = "queryAllOrders")
    List<OrdersCommodity> queryAllOrders();

}
