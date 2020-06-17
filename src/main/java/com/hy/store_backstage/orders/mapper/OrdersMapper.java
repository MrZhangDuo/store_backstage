package com.hy.store_backstage.orders.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.orders.Providers.OrderUpdateProviders;
import com.hy.store_backstage.seckill.entity.bo.SeckillBo;
import com.hy.store_backstage.utils.Count;
import com.hy.store_backstage.orders.Providers.select.queryAllOrders;
import com.hy.store_backstage.orders.entity.Orders;
import com.hy.store_backstage.orders.entity.bo.OrdersCommodity;
import com.hy.store_backstage.utils.CountMoney;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

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
    IPage<OrdersCommodity> queryAllOrders(@Param("ipage")IPage<SeckillBo> page , @Param("orderPeople")String orderPeople,@Param("orderStatus")String orderStatus);

    @SelectProvider(type = queryAllOrders.class,method = "ordersMoneyCountBZ")
    CountMoney ordersMoneyCountBZ();

    @SelectProvider(type = queryAllOrders.class,method = "ordersMoneyCountSZ")
    CountMoney ordersMoneyCountSZ();

    @SelectProvider(type = queryAllOrders.class,method = "ordersCountBZ")
    Count ordersCountBZ();

    @SelectProvider(type = queryAllOrders.class,method = "ordersCountSZ")
    Count ordersCountSZ();

    @UpdateProvider(type = OrderUpdateProviders.class,method = "examine")
    Integer examine(Long orderId,String orderStatus);

}
