package com.hy.store_backstage.orders.Providers.select;

import java.io.Serializable;

/**
 * @ClassName QueryAllSeckill
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/4 19:27
 * @Version 1.0
 */
public class queryAllOrders implements Serializable {

    /**
     * @Author zhangduo
     * @Description //TODO 查询所有订单
     * @Date 19:47 2020/6/4
     * @Param
     * @return
     **/
    public String queryAllOrders(){
        StringBuffer stringBuffer = new StringBuffer("SELECT  o.order_id as order_id, o.order_no,o.order_people,o.order_address,o.order_time,o.order_mony,o.order_number,o.order_status,c.com_id,c.com_name FROM orders o, commodity c WHERE o.order_commodity = c.com_id and 1=1");
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }
}
