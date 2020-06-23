package com.hy.store_backstage.commodity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.commodity.entity.GoOutRepertoryBean;
import com.hy.store_backstage.commodity.entity.RepertoryBean;

import java.util.List;

public interface IRepertoryService {

    /*根据商品id查询库存的所有信息*/
    public List<RepertoryBean> selectGoTo(Long comId);

    /*修改库存信息*/
    public void updatGoTo(RepertoryBean repertoryBean);

    /*生成的sku编码*/
    public String bianma();

    /*查询商品入库的信息*/
    public List<GoOutRepertoryBean> selectGo();
    /*查询商品出库的信息*/
    public List<GoOutRepertoryBean> selectOut();

    /*入库信息模糊查询*/
    public IPage<GoOutRepertoryBean> selectLikeGo(Integer currentPage, Integer pageSize, GoOutRepertoryBean goOutRepertoryBean);
    /*查询入库商品的总数量*/
    public Integer goNumber();
    /*出库信息模糊查询*/
    public IPage<GoOutRepertoryBean> selectLikeOut(Integer currentPage, Integer pageSize,GoOutRepertoryBean goOutRepertoryBean);
    /*查询出库商品的总数量*/
    public Integer outNumber();
}
