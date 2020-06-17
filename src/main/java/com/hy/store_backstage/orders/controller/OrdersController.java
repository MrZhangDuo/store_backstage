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
     * @Date 9:58 2020/6/5
     * @Param
     * @return List<OrdersCommodity>
     **/
    @RequestMapping(value = "/queryAllOrders" , method = RequestMethod.GET)
    public IPage<OrdersCommodity> queryAllOrders(String orderStatus,String orderPeople, Integer currentPage, Integer pageSize) {
        return this.ordersService.queryAllOrders(orderStatus,orderPeople,currentPage,pageSize);
    }

    @RequestMapping("queryOrderById")
    public Orders queryOrderById(Long orderId){
        return ordersService.queryOrderById(orderId);
    }

    @RequestMapping("updateOrderById")
    public ReturnJson updateOrderById(Orders orders,String orderTimes){
        return ordersService.updateOrderById(orders,orderTimes);
    }

    @RequestMapping("ordersMoneyCountBZ")
    public List<Double> ordersMoneyCountBZ() {
        return ordersService.ordersMoneyCountBZ();
    }

    @RequestMapping("ordersMoneyCountSZ")
    public List<Double> ordersMoneyCountSZ() {
        return ordersService.ordersMoneyCountSZ();
    }


    @RequestMapping("ordersCountBZ")
    public List<Integer> ordersCountBZ() {
        return ordersService.ordersCountBZ();
    }

    @RequestMapping("ordersCountSZ")
    public List<Integer> ordersCountSZ() {
        return ordersService.ordersCountSZ();
    }
}
