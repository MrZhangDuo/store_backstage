package com.hy.store_backstage.commodity.mapper;

import com.hy.store_backstage.commodity.entity.CommodityEntity;
import com.hy.store_backstage.commodity.entity.EvaluateFEntity;
import com.hy.store_backstage.commodity.entity.GoOutRepertoryBean;
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


    public String selectLikeGo(GoOutRepertoryBean goOutRepertoryBean){
        String sql="SELECT C.com_img AS 'comImg',C.com_name AS 'comName',C.com_brand AS 'comBrand',C.com_no AS 'comNo',O.order_no AS 'orderNo', G.repertory_number AS 'repertoryNumber',G.handle_type AS 'handleType',G.goout_time AS 'gooutTime',G.goout_person AS 'gooutPerson',G.color_name as colorName,G.size_name as sizeName FROM commodity C,orders O,commodity_goout G WHERE C.com_id=O.order_commodity AND C.com_id=G.com_id AND G.differ_both=1 and 1=1";
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

    public String selectLikeOut(GoOutRepertoryBean goOutRepertoryBean){
        String sql="SELECT C.com_img AS 'comImg',C.com_name AS 'comName',C.com_brand AS 'comBrand',C.com_no AS 'comNo',O.order_no AS 'orderNo', G.repertory_number AS 'repertoryNumber',G.handle_type AS 'handleType',G.goout_time AS 'gooutTime',G.goout_person AS 'gooutPerson',G.color_name as colorName,G.size_name as sizeName FROM commodity C,orders O,commodity_goout G WHERE C.com_id=O.order_commodity AND C.com_id=G.com_id AND G.differ_both=2 and 1=1";
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
    public String selectPingjiaLike(EvaluateFEntity evaluateFEntity){
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
