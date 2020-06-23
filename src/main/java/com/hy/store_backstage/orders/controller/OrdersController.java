package com.hy.store_backstage.orders.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.orders.entity.Orders;
import com.hy.store_backstage.orders.entity.bo.OrdersCommodity;
import com.hy.store_backstage.orders.service.impl.OrdersServiceImpl;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@RestController
@Transactional
@RequestMapping("/orders")
@CrossOrigin
public class OrdersController {

    @Autowired
    OrdersServiceImpl ordersService;


    /**
     * @Author zhangduo
     * @Description //TODO 查询所有订单
     * @Date 10:16 2020/6/17
     * @Param [orderStatus, orderPeople, currentPage, pageSize]
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.hy.store_backstage.orders.entity.bo.OrdersCommodity>
     **/
    @RequestMapping(value = "/queryAllOrders" , method = RequestMethod.GET)
    public IPage<OrdersCommodity> queryAllOrders(String orderStatus,String orderPeople, Integer currentPage, Integer pageSize) {
        return this.ordersService.queryAllOrders(orderStatus,orderPeople,currentPage,pageSize);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 查询某个订单
     * @Date 10:17 2020/6/17
     * @Param [orderId]
     * @return com.hy.store_backstage.orders.entity.Orders
     **/
    @RequestMapping("queryOrderById")
    public Orders queryOrderById(Long orderId){
        return ordersService.queryOrderById(orderId);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 修改某个订单
     * @Date 10:17 2020/6/17
     * @Param [orders, orderTimes]
     * @return com.hy.store_backstage.utils.ReturnJson
     **/
    @RequestMapping("updateOrderById")
    public ReturnJson updateOrderById(Orders orders,String orderTimes){
        return ordersService.updateOrderById(orders,orderTimes);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 统计本周订单为已收货的金额
     * @Date 10:17 2020/6/17
     * @Param []
     * @return java.util.List<java.lang.Double>
     **/
    @RequestMapping("ordersMoneyCountBZ")
    public List<Double> ordersMoneyCountBZ() {
        return ordersService.ordersMoneyCountBZ();
    }

    /**
     * @Author zhangduo
     * @Description //TODO 统计上周订单为已收货的金额
     * @Date 10:17 2020/6/17
     * @Param []
     * @return java.util.List<java.lang.Double>
     **/
    @RequestMapping("ordersMoneyCountSZ")
    public List<Double> ordersMoneyCountSZ() {
        return ordersService.ordersMoneyCountSZ();
    }

    /**
     * @Author zhangduo
     * @Description //TODO 统计本周订单交易量
     * @Date 10:18 2020/6/17
     * @Param []
     * @return java.util.List<java.lang.Integer>
     **/
    @RequestMapping("ordersCountBZ")
    public List<Integer> ordersCountBZ() {
        return ordersService.ordersCountBZ();
    }

    /**
     * @Author zhangduo
     * @Description //TODO 统计上周订单交易量
     * @Date 10:18 2020/6/17
     * @Param []
     * @return java.util.List<java.lang.Integer>
     **/
    @RequestMapping("ordersCountSZ")
    public List<Integer> ordersCountSZ() {
        return ordersService.ordersCountSZ();
    }
}
