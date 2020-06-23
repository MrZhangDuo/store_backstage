package com.hy.store_backstage.commodity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.commodity.entity.EvaluateFEntity;
import com.hy.store_backstage.commodity.entity.EvaluateSEntity;

public interface IEvaluateFService {
    /*根据父评论下的所有子评论*/
    public IPage<EvaluateSEntity> selectSonInfo(Integer currentPage, Integer pageSize,Integer evaId);
    /*添加管理员评论的信息*/
    public void addMassageInfo(EvaluateSEntity evaluateSEntity);
    /*查询父商品评价的条数*/
    public Integer countEva();
    /*查询父评论下子评论的数量*/
    public Integer sonNumber(Integer evaId);

    /*根据商品名称或用户昵称模糊查询父评价*/
    public IPage<EvaluateFEntity> selectPingjiaLike(Integer currentPage, Integer pageSize, EvaluateFEntity evaluateFEntity);
}
