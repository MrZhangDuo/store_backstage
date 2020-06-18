package com.hy.store_backstage.commodity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.commodity.entity.EvaluateFEntity;
import com.hy.store_backstage.commodity.entity.EvaluateSEntity;
import com.hy.store_backstage.commodity.mapper.EvaluateFMapper;
import com.hy.store_backstage.commodity.service.IEvaluateFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EvaluateFService extends ServiceImpl<EvaluateFMapper,EvaluateFEntity > implements IEvaluateFService {

    @Autowired
    private EvaluateFMapper evaluateFMapper;

    /*根据父评论下的所有子评论*/
    public List<EvaluateSEntity> selectSonInfo(Integer evaId){
      return evaluateFMapper.selectSonInfo(evaId);
    };

    /*添加管理员评论的信息*/
    public void addMassageInfo(EvaluateSEntity evaluateSEntity){
        evaluateFMapper.addMassageInfo(evaluateSEntity);
    };
    /*根据商品名称或用户昵称模糊查询父评价*/
    public List<EvaluateFEntity> selectPingjiaLike(EvaluateFEntity evaluateFEntity){
       return evaluateFMapper.selectPingjiaLike(evaluateFEntity);
    };
}
