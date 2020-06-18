package com.hy.store_backstage.returns.provider;

import com.hy.store_backstage.returns.entity.Returns;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

/**
 * @ClassName SelectProviders
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/15 11:00
 * @Version 1.0
 */
public class SelectProviders {

    public String queryAllOrders(@Param("returns") Returns returns){
        StringBuffer stringBuffer = new StringBuffer("SELECT ret.*,com.* ,o.* FROM RETURNS ret LEFT JOIN commodity com ON ret.`return_commodity`=com.`com_id` LEFT JOIN orders o ON ret.`orderid`=o.`order_id` where 1=1");
        if(!StringUtils.isEmpty(returns)){
            if(!StringUtils.isEmpty(returns.getOrderNo())){
                stringBuffer.append(" and o.order_no like '%"+returns.getOrderNo()+"%'");
            }
            if(!StringUtils.isEmpty(returns.getReturnType())){
                stringBuffer.append(" and ret.return_type='"+returns.getReturnType()+"'");
            }
            if(!StringUtils.isEmpty(returns.getApplyforStatus())){
                stringBuffer.append(" and ret.applyfor_status='"+returns.getApplyforStatus()+"'");
            }
        }
        return stringBuffer.toString();
    }
}
