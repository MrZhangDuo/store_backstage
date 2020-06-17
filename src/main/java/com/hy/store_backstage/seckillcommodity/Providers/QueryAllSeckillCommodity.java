package com.hy.store_backstage.seckillcommodity.Providers;

import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @ClassName QueryAllSeckillCommodity
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/10 15:22
 * @Version 1.0
 */
public class QueryAllSeckillCommodity {
    public String queryAllSeckillCommodity(Integer seckillId,String comName){
        StringBuffer stringBuffer = new StringBuffer("select s.* , c.* from seckillcommodity s left join commodity c on s.`commodityId`=c.`com_id`  where 1=1  ");
        if(seckillId>0){
            stringBuffer.append(" and s.seckillId="+seckillId+"");
        }
        if(!StringUtils.isEmpty(comName)){
            stringBuffer.append(" and c.com_name like'%"+comName+"%'");
        }
        stringBuffer.append(" order by sort");
        return stringBuffer.toString();
    }


    public String queryInCommodityId(String commodityId){
        StringBuffer stringBuffer = new StringBuffer("SELECT * FROM commodity WHERE 1=1  ");
        if(!StringUtils.isEmpty(commodityId)){
            stringBuffer.append(" and com_id IN ("+commodityId+")");
        }
        return stringBuffer.toString();
    }
}
