package com.hy.store_backstage.commodity.mapper;

import com.hy.store_backstage.commodity.entity.CommodityEntity;
import com.hy.store_backstage.commodity.entity.EvaluateFEntity;
import com.hy.store_backstage.commodity.entity.GoOutRepertoryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

public class UniteSelect {

    /*模糊查询商品列表信息*/
    public String selectLike(@Param("commodityEntity") CommodityEntity commodityEntity){
        StringBuffer sql=new StringBuffer("select * from commodity where 1=1");
        if(!StringUtils.isEmpty(commodityEntity.getComName())){
            sql.append(" and com_name like '%"+commodityEntity.getComName()+"%'");
        }
        if(!StringUtils.isEmpty(commodityEntity.getComBrand())){
            sql.append(" and com_brand like '%"+commodityEntity.getComBrand()+"%'");
        }
        if(!StringUtils.isEmpty(commodityEntity.getComNo())){
            sql.append(" and com_no like '%"+commodityEntity.getComNo()+"%'");
        }
        sql.append(" ORDER BY com_label");
        return sql.toString();
    }

    /*模糊查询商品审核的信息*/
    public String selectCheckInfo(@Param("commodityEntity") CommodityEntity commodityEntity){
        StringBuilder sql=new StringBuilder("select * from commodity where com_state='2' and com_label='未上架'");
        if(!StringUtils.isEmpty(commodityEntity.getComName())){
            sql.append(" and com_name like '%"+commodityEntity.getComName()+"%'");
        }
        if(!StringUtils.isEmpty(commodityEntity.getComBrand())){
            sql.append(" and com_brand like '%"+commodityEntity.getComBrand()+"%'");
        }
        if(!StringUtils.isEmpty(commodityEntity.getComNo())){
            sql.append(" and com_no like '%"+commodityEntity.getComNo()+"%'");
        }
        return sql.toString();
    }


    /*模糊查询入库信息*/
    public String selectLikeGo(@Param("goOutRepertoryBean") GoOutRepertoryBean goOutRepertoryBean){
        String sql="SELECT c.com_img comImg,c.com_name comName,c.com_no comNo,g.size_name sizeName,g.color_name colorName,g.goout_number gooutNumber,\n" +
                   "(g.goout_number+g.repertory_number) repertoryNumber,g.handle_type handleType,g.goout_time gooutTime,g.goout_person gooutPerson,o.order_no orderNo \n" +
                   "FROM commodity c,commodity_goout g,orders o WHERE c.com_id=g.com_id AND g.`order_id`= o.`order_id` AND differ_both=1 and 1=1";
        StringBuilder sql2=new StringBuilder(sql);

        if(!StringUtils.isEmpty(goOutRepertoryBean.getComNo())){
            sql2.append(" and C.com_no like '%"+goOutRepertoryBean.getComNo()+"%'");
        }
        if(!StringUtils.isEmpty(goOutRepertoryBean.getComName())){
            sql2.append(" and C.com_name like '%"+goOutRepertoryBean.getComName()+"%'");
        }
        if(!StringUtils.isEmpty(goOutRepertoryBean.getGooutTime())){
            sql2.append(" and G.goout_time like '%"+goOutRepertoryBean.getGooutTime()+"%'");
        }
        return sql2.toString();
    }

    /*模糊查询出库信息*/
    public String selectLikeOut(@Param("goOutRepertoryBean")GoOutRepertoryBean goOutRepertoryBean){
        String sql="SELECT c.com_img comImg,c.com_name comName,c.com_no comNo,g.size_name sizeName,g.color_name colorName,g.goout_number gooutNumber,\n" +
                   "(g.repertory_number-g.goout_number) repertoryNumber,g.handle_type handleType,g.goout_time gooutTime,g.goout_person gooutPerson,o.order_no orderNo \n" +
                   "FROM commodity c,commodity_goout g,orders o WHERE c.com_id=g.com_id AND g.`order_id`= o.`order_id` AND differ_both=2 and 1=1";
        StringBuilder sql2=new StringBuilder(sql);

        if(!StringUtils.isEmpty(goOutRepertoryBean.getComNo())){
            sql2.append(" and C.com_no like '%"+goOutRepertoryBean.getComNo()+"%'");
        }
        if(!StringUtils.isEmpty(goOutRepertoryBean.getComName())){
            sql2.append(" and C.com_name like '%"+goOutRepertoryBean.getComName()+"%'");
        }
        if(!StringUtils.isEmpty(goOutRepertoryBean.getGooutTime())){
            sql2.append(" and G.goout_time like'%"+goOutRepertoryBean.getGooutTime()+"%'");
        }
        return sql2.toString();
    }

    /*根据商品名称或用户昵称模糊查询*/
    public String selectPingjiaLike(@Param("evaluateFEntity")EvaluateFEntity evaluateFEntity){
        StringBuilder sb=new StringBuilder("select * from evaluatefather where 1=1");

        if(!StringUtils.isEmpty(evaluateFEntity.getEvaComname())){
            sb.append(" and eva_comname like '%"+evaluateFEntity.getEvaComname()+"%'");
        }
        if(!StringUtils.isEmpty(evaluateFEntity.getEvaUesrname())){
            sb.append(" and eva_uesrname like '%"+evaluateFEntity.getEvaUesrname()+"%'");
        }
        return  sb.toString();
    }
}
