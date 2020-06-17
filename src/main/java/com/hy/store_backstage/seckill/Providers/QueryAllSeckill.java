package com.hy.store_backstage.seckill.Providers;

import com.hy.store_backstage.seckill.entity.bo.SeckillBo;
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
public class QueryAllSeckill implements Serializable {

    /**
     * @Author zhangduo
     * @Description //TODO 查询所有订单
     * @Date 19:47 2020/6/4
     * @Param
     * @return
     **/
    public String queryAllSeckill(@Param("seckillBo") SeckillBo seckillBo){
        StringBuffer stringBuffer = new StringBuffer("SELECT s.*,COUNT(scom.`seckillId`)seckillComNum FROM seckill s LEFT JOIN seckillcommodity scom ON s.`seckillId`=scom.`seckillId` where 1=1  ");
        if (!StringUtils.isEmpty(seckillBo)){
            if(!StringUtils.isEmpty(seckillBo.getSeckillTitle())){
                stringBuffer.append(" and s.seckillTitle like '%"+seckillBo.getSeckillTitle()+"%'");
            }
            if(!StringUtils.isEmpty(seckillBo.getSeckillStatus())){
                stringBuffer.append(" and s.seckillStatus ="+seckillBo.getSeckillStatus()+"");
            }
            if(!StringUtils.isEmpty(seckillBo.getStartTime()) && !StringUtils.isEmpty(seckillBo.getEndTime())){
                stringBuffer.append(" and s.startTime BETWEEN '"+seckillBo.getStartTime()+"' and '"+seckillBo.getEndTime()+"'");
            }
        }
        stringBuffer.append(" GROUP BY s.`seckillId` ORDER BY s.`sort` desc");
        return stringBuffer.toString();
    }
}
