package com.hy.store_backstage.orders.Providers;

/**
 * @ClassName UpdateProviders
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/16 17:35
 * @Version 1.0
 */
public class OrderUpdateProviders {
    public String examine(Long orderId,String orderStatus){
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append("UPDATE orders SET order_status='"+orderStatus+"' WHERE order_id="+orderId+"").toString();
    }
}
