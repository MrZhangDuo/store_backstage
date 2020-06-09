package com.hy.store_backstage.commodity.mapper;

import com.hy.store_backstage.commodity.entity.CommodityEntity;
import org.springframework.util.StringUtils;

public class UniteSelect {

    public String selectLike(CommodityEntity commodity){
        StringBuffer sql=new StringBuffer("select * from commodity where 1=1");
        if(!StringUtils.isEmpty(commodity.getComName())){
            sql.append(" and com_name like '%"+commodity.getComName()+"%'");
        }
        if(!StringUtils.isEmpty(commodity.getComBrand())){
            sql.append(" and com_brand like '%"+commodity.getComBrand()+"%'");
        }
        if(!StringUtils.isEmpty(commodity.getComNo())){
            sql.append(" and com_no like '%"+commodity.getComNo()+"%'");
        }
        return sql.toString();
    }
}
