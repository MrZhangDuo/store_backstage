package com.hy.store_backstage.orders.controller;


import com.hy.store_backstage.orders.entity.bo.OrdersCommodity;
import com.hy.store_backstage.orders.service.impl.OrdersServiceImpl;
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
    @CrossOrigin
    @RequestMapping(value = "/queryAllOrders" , method = RequestMethod.GET)
    public List<OrdersCommodity> queryAllOrders() {
        System.out.println(1111111111);
        return this.ordersService.queryAllOrders();
    }

}
