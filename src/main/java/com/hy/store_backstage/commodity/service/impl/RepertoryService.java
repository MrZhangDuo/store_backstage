package com.hy.store_backstage.commodity.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.commodity.entity.GoOutRepertoryBean;
import com.hy.store_backstage.commodity.entity.RepertoryBean;
import com.hy.store_backstage.commodity.mapper.RepertoryMapper;
import com.hy.store_backstage.commodity.service.IRepertoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RepertoryService  extends ServiceImpl<RepertoryMapper , RepertoryBean > implements IRepertoryService {
  @Resource
   private RepertoryMapper repertoryMapper;


    /*根据商品id查询库存的所有信息*/
    public List<RepertoryBean> selectGoTo(Long comId){
        return repertoryMapper.selectGoTo(comId);
    };
    /*修改库存信息*/
    public void updatGoTo(RepertoryBean repertoryBean){
        repertoryMapper.updatGoTo(repertoryBean);
    };
    /*生成的sku编码*/
    public String bianma(){
       return repertoryMapper.bianma();
    };

    /*查询商品入库的信息*/
    public List<GoOutRepertoryBean> selectGo(){
        return repertoryMapper.selectGo();
    };
    /*查询商品出库的信息*/
    public List<GoOutRepertoryBean> selectOut(){
        return repertoryMapper.selectOut();
    };

    /*入库信息模糊查询*/
    public IPage<GoOutRepertoryBean> selectLikeGo(Integer currentPage, Integer pageSize,GoOutRepertoryBean goOutRepertoryBean){
        return repertoryMapper.selectLikeGo(new Page(currentPage,pageSize),goOutRepertoryBean);
    };
    /*查询入库商品的总数量*/
    public Integer goNumber(){
        return repertoryMapper.goNumber();
    };

    /*出库信息模糊查询*/
    public IPage<GoOutRepertoryBean> selectLikeOut(Integer currentPage, Integer pageSize,GoOutRepertoryBean goOutRepertoryBean){
        return repertoryMapper.selectLikeOut(new Page(currentPage,pageSize),goOutRepertoryBean);
    };
    /*查询出库商品的总数量*/
    public Integer outNumber(){
        return repertoryMapper.outNumber();
    };


}
