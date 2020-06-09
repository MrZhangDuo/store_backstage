package com.hy.store_backstage.orders.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.orders.entity.Orders;
import com.hy.store_backstage.orders.entity.bo.OrdersCommodity;
import com.hy.store_backstage.orders.mapper.OrdersMapper;
import com.hy.store_backstage.orders.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    /**
     * @Author zhangduo
     * @Description //TODO 查询所有订单
     * @Date 19:47 2020/6/4
     * @Param
     * @return List<OrdersCommodity>
     **/
    @Override
    public List<OrdersCommodity> queryAllOrders() {
        return this.ordersMapper.queryAllOrders();
    }
}
