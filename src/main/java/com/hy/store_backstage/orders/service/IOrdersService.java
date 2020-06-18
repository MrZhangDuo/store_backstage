package com.hy.store_backstage.orders.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.store_backstage.orders.entity.Orders;
import com.hy.store_backstage.orders.entity.bo.OrdersCommodity;
import com.hy.store_backstage.orders.mapper.OrdersMapper;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
public interface IOrdersService extends IService<Orders> {

    /**
     * @Author zhangduo
     * @Description //TODO 查询所有订单
     * @Date 19:47 2020/6/4
     * @Param
     * @return
     **/
    IPage<OrdersCommodity> queryAllOrders(String orderStatus,String orderPeople, Integer currentPage, Integer pageSize);

    List<Double> ordersMoneyCountBZ();
    List<Double> ordersMoneyCountSZ();
    List<Integer> ordersCountBZ();
    List<Integer> ordersCountSZ();
    Orders queryOrderById(Long orderId);
    ReturnJson updateOrderById(Orders orders,String orderTimes);

}
