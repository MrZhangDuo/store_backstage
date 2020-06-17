package com.hy.store_backstage.orders.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.orders.entity.Orders;
import com.hy.store_backstage.orders.entity.bo.OrdersCommodity;
import com.hy.store_backstage.orders.mapper.OrdersMapper;
import com.hy.store_backstage.orders.service.IOrdersService;
import com.hy.store_backstage.utils.Count;
import com.hy.store_backstage.utils.CountList;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    public IPage<OrdersCommodity> queryAllOrders(String orderStatus,String orderPeople, Integer currentPage, Integer pageSize) {
        return this.ordersMapper.queryAllOrders(new Page(currentPage,pageSize),orderPeople,orderStatus);
    }

    @Override
    public List<Double> ordersMoneyCountBZ() {
        return CountList.countMoneyList(ordersMapper.ordersMoneyCountBZ());
    }

    @Override
    public List<Double> ordersMoneyCountSZ() {
        return CountList.countMoneyList(ordersMapper.ordersMoneyCountSZ());
    }

    @Override
    public List<Integer> ordersCountBZ() {
        return CountList.countList(ordersMapper.ordersCountBZ());
    }

    @Override
    public List<Integer> ordersCountSZ() {
        return CountList.countList(ordersMapper.ordersCountSZ());
    }

    @Override
    public Orders queryOrderById(Long orderId) {
        return ordersMapper.selectById(orderId);
    }

    @Override
    public ReturnJson updateOrderById(Orders orders,String orderTimes) {
        if(!StringUtils.isEmpty(orderTimes)){
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            orders.setOrderTime(LocalDateTime.parse(orderTimes.replace("T"," "),dt));
        }
        int returns = ordersMapper.updateById(orders);
        if(returns>0){
            return new ReturnJson(200,"修改成功!!!");
        }else{
            return new ReturnJson(401,"修改失败!!!");
        }
    }
}
