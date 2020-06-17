package com.hy.store_backstage.customer.provider;

import com.hy.store_backstage.customer.entity.CustomerBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

/**
 * @ClassName SelectProvider
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/14 13:34
 * @Version 1.0
 */
public class SelectProvider {

    public String queryAllCustomer(@Param(value = "customerBo") CustomerBo customerBo){
        StringBuffer stringBuffer = new StringBuffer("select " +
                "c.*,COALESCE(SUM(o.`order_mony`),0) as order_mony,count(o.`order_custid`)order_count " +
                "from customer c left join orders o " +
                "on ( trim(c.`cust_id`)=trim(o.`order_custid`) and o.`order_status`='已收货') " +
                "where 1=1");
        if(!StringUtils.isEmpty(customerBo)){
            if(!StringUtils.isEmpty(customerBo.getCustAccount())){
                stringBuffer.append(" and cust_account like '%"+customerBo.getCustAccount()+"%'");
            }
            if(!StringUtils.isEmpty(customerBo.getCustName())){
                stringBuffer.append(" and cust_name like '%"+customerBo.getCustName()+"%'");
            }
            if(!StringUtils.isEmpty(customerBo.getTimes())){
                stringBuffer.append(" and times='"+customerBo.getTimes()+"'");
            }
        }
        stringBuffer.append(" group by c.`cust_id`");
        return stringBuffer.toString();
    }
    public String customerCountBZ(){
        StringBuffer stringBuffer = new StringBuffer("select c1.Monday,c2.Tuesday,c3.Wednesday,c4.Thursday,c5.Friday,c6.Saturday,c7.Sunday from \n" +
                "(SELECT count(times) Monday FROM customer WHERE times = SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-1)) c1,\n" +
                "(SELECT COUNT(times)Tuesday FROM customer WHERE times = SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-2))c2,\n" +
                "(SELECT count(times)Wednesday FROM customer WHERE times = SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-3))c3,\n" +
                "(SELECT count(times)Thursday FROM customer WHERE times = SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-4))c4,\n" +
                "(SELECT count(times)Friday FROM customer WHERE times = SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-5))c5,\n" +
                "(SELECT count(times)Saturday FROM customer WHERE times = SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-6))c6,\n" +
                "(SELECT COUNT(times)Sunday FROM customer WHERE times = SUBDATE(CURDATE(),DATE_FORMAT(CURDATE(),'%w')-7))c7");
        return stringBuffer.toString();
    }
    public String customerCountSZ(){
        StringBuffer stringBuffer = new StringBuffer("select c1.Monday,c2.Tuesday,c3.Wednesday,c4.Thursday,c5.Friday,c6.Saturday,c7.Sunday from \n" +
                "(SELECT count(times) Monday FROM customer WHERE times = DATE(DATE_SUB(subdate(curdate(),date_format(curdate(),'%w')-1), interval 7 day))) c1,\n" +
                "(SELECT COUNT(times)Tuesday FROM customer WHERE times = DATE(DATE_SUB(subdate(curdate(),date_format(curdate(),'%w')-1), interval 6 day)))c2,\n" +
                "(SELECT count(times)Wednesday FROM customer WHERE times = DATE(DATE_SUB(subdate(curdate(),date_format(curdate(),'%w')-1), interval 5 day)))c3,\n" +
                "(SELECT count(times)Thursday FROM customer WHERE times = DATE(DATE_SUB(subdate(curdate(),date_format(curdate(),'%w')-1), interval 4 day)))c4,\n" +
                "(SELECT count(times)Friday FROM customer WHERE times = DATE(DATE_SUB(subdate(curdate(),date_format(curdate(),'%w')-1), interval 3 day)))c5,\n" +
                "(SELECT count(times)Saturday FROM customer WHERE times = DATE(DATE_SUB(subdate(curdate(),date_format(curdate(),'%w')-1), interval 2 day)))c6,\n" +
                "(SELECT COUNT(times)Sunday FROM customer WHERE times = DATE(DATE_SUB(subdate(curdate(),date_format(curdate(),'%w')-1), interval 1 day)))c7");
        return stringBuffer.toString();
    }
}
