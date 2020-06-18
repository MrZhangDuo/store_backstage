package com.hy.store_backstage.commodity.service;

import com.hy.store_backstage.commodity.entity.EvaluateFEntity;
import com.hy.store_backstage.commodity.entity.EvaluateSEntity;

import java.util.List;

public interface IEvaluateFService {
    /*根据父评论下的所有子评论*/
    public List<EvaluateSEntity> selectSonInfo(Integer evaId);
    /*添加管理员评论的信息*/
    public void addMassageInfo(EvaluateSEntity evaluateSEntity);
    /*根据商品名称或用户昵称模糊查询父评价*/
    public List<EvaluateFEntity> selectPingjiaLike(EvaluateFEntity evaluateFEntity);
}
