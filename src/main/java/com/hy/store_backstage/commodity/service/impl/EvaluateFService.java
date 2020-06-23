package com.hy.store_backstage.commodity.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.commodity.entity.EvaluateFEntity;
import com.hy.store_backstage.commodity.entity.EvaluateSEntity;
import com.hy.store_backstage.commodity.mapper.EvaluateFMapper;
import com.hy.store_backstage.commodity.service.IEvaluateFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EvaluateFService extends ServiceImpl<EvaluateFMapper,EvaluateFEntity > implements IEvaluateFService {

    @Autowired
    private EvaluateFMapper evaluateFMapper;

    /*根据父评论下的所有子评论*/
    public IPage<EvaluateSEntity> selectSonInfo(Integer currentPage, Integer pageSize,Integer evaId){
      return evaluateFMapper.selectSonInfo(new Page(currentPage,pageSize),evaId);
    };

    /*添加管理员评论的信息*/
    public void addMassageInfo(EvaluateSEntity evaluateSEntity){
        evaluateFMapper.addMassageInfo(evaluateSEntity);
    };

    /*查询父商品评价的条数*/
    public Integer countEva(){
        return evaluateFMapper.countEva();
    };
    /*查询父评论下子评论的数量*/
    public Integer sonNumber(Integer evaId){
        return evaluateFMapper.sonNumber(evaId);
    };

    /*根据商品名称或用户昵称模糊查询父评价*/
    public IPage<EvaluateFEntity> selectPingjiaLike(Integer currentPage, Integer pageSize,EvaluateFEntity evaluateFEntity){
       return evaluateFMapper.selectPingjiaLike(new Page(currentPage,pageSize),evaluateFEntity);
    };
}
