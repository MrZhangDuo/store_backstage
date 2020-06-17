package com.hy.store_backstage.orders.Providers.select;

import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

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
    public String queryAllOrders(@Param("orderPeople")String orderPeople,@Param("orderStatus")String orderStatus){
        StringBuffer stringBuffer = new StringBuffer("SELECT  o.order_id as order_id, o.order_no,o.order_people,o.order_address,o.order_time,o.order_mony,o.order_number,o.order_status,c.* FROM orders o, commodity c WHERE o.order_commodity = c.com_id and 1=1");
        if(!StringUtils.isEmpty(orderPeople)){
            stringBuffer.append(" and o.order_people like '%"+orderPeople+"%'");
        }
        if(!StringUtils.isEmpty(orderStatus)){
            stringBuffer.append(" and o.order_status='"+orderStatus+"'");
        }
        return stringBuffer.toString();
    }

    public String ordersMoneyCountBZ(){
        StringBuffer stringBuffer = new StringBuffer("SELECT o1.Monday,o2.Tuesday,o3.Wednesday,o4.Thursday,o5.Friday,o6.Saturday,o7.Sunday FROM \n" +
                "(SELECT COALESCE(SUM(order_mony),0)Monday    FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1))o1,\n" +
                "(SELECT COALESCE(SUM(order_mony),0)Tuesday   FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-2))o2,\n" +
                "(SELECT COALESCE(SUM(order_mony),0)Wednesday FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-3))o3,\n" +
                "(SELECT COALESCE(SUM(order_mony),0)Thursday  FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-4))o4,\n" +
                "(SELECT COALESCE(SUM(order_mony),0)Friday    FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-5))o5,\n" +
                "(SELECT COALESCE(SUM(order_mony),0)Saturday  FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-6))o6,\n" +
                "(SELECT COALESCE(SUM(order_mony),0)Sunday    FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-7))o7\n");
        return stringBuffer.toString();
    }
    public String ordersMoneyCountSZ(){
        StringBuffer stringBuffer = new StringBuffer("select o1.Monday,o2.Tuesday,o3.Wednesday,o4.Thursday,o5.Friday,o6.Saturday,o7.Sunday from \n" +
                "(SELECT COALESCE(SUM(order_mony),0)Monday    FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(subdate(curdate(),date_format(curdate(),'%w')-1), interval 7 day)))o1,\n" +
                "(SELECT COALESCE(SUM(order_mony),0)Tuesday   FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1), INTERVAL 6 DAY)))o2,\n" +
                "(SELECT COALESCE(SUM(order_mony),0)Wednesday FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1), INTERVAL 5 DAY)))o3,\n" +
                "(SELECT COALESCE(SUM(order_mony),0)Thursday  FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1), INTERVAL 4 DAY)))o4,\n" +
                "(SELECT COALESCE(SUM(order_mony),0)Friday    FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1), INTERVAL 3 DAY)))o5,\n" +
                "(SELECT COALESCE(SUM(order_mony),0)Saturday  FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1), INTERVAL 2 DAY)))o6,\n" +
                "(SELECT COALESCE(SUM(order_mony),0)Sunday    FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1), INTERVAL 1 DAY)))o7");
        return stringBuffer.toString();
    }

    public String ordersCountBZ(){
        StringBuffer stringBuffer = new StringBuffer("select o1.Monday,o2.Tuesday,o3.Wednesday,o4.Thursday,o5.Friday,o6.Saturday,o7.Sunday from \n" +
                "(SELECT COUNT(1)Monday    FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1))o1,\n" +
                "(SELECT COUNT(1)Tuesday   FROM orders WHERE date_format(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-2))o2,\n" +
                "(SELECT COUNT(1)Wednesday FROM orders WHERE date_format(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-3))o3,\n" +
                "(SELECT COUNT(1)Thursday  FROM orders WHERE date_format(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-4))o4,\n" +
                "(SELECT COUNT(1)Friday    FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-5))o5,\n" +
                "(SELECT COUNT(1)Saturday  FROM orders WHERE date_format(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-6))o6,\n" +
                "(SELECT COUNT(1)Sunday    FROM orders WHERE date_format(order_time,'%Y-%m-%d')=SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-7))o7");
        return stringBuffer.toString();
    }
    public String ordersCountSZ(){
        StringBuffer stringBuffer = new StringBuffer("select o1.Monday,o2.Tuesday,o3.Wednesday,o4.Thursday,o5.Friday,o6.Saturday,o7.Sunday from \n" +
                "(SELECT COUNT(1)Monday    FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(subdate(curdate(),date_format(curdate(),'%w')-1), interval 7 day)))o1,\n" +
                "(SELECT COUNT(1)Tuesday   FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1), INTERVAL 6 DAY)))o2,\n" +
                "(SELECT COUNT(1)Wednesday FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1), INTERVAL 5 DAY)))o3,\n" +
                "(SELECT COUNT(1)Thursday  FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1), INTERVAL 4 DAY)))o4,\n" +
                "(SELECT COUNT(1)Friday    FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1), INTERVAL 3 DAY)))o5,\n" +
                "(SELECT COUNT(1)Saturday  FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1), INTERVAL 2 DAY)))o6,\n" +
                "(SELECT COUNT(1)Sunday    FROM orders WHERE DATE_FORMAT(order_time,'%Y-%m-%d')=DATE(DATE_SUB(SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1), INTERVAL 1 DAY)))o7");
        return stringBuffer.toString();
    }
}
