package com.hy.store_backstage.seckillcommodity.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.store_backstage.commodity.entity.CommodityEntity;
import com.hy.store_backstage.seckillcommodity.entity.SeckillCommodityBo;
import com.hy.store_backstage.seckillcommodity.entity.Seckillcommodity;
import com.hy.store_backstage.seckillcommodity.mapper.SeckillcommodityMapper;
import com.hy.store_backstage.seckillcommodity.service.ISeckillcommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-10
 */
@Service
public class SeckillcommodityServiceImpl extends ServiceImpl<SeckillcommodityMapper, Seckillcommodity> implements ISeckillcommodityService {
    @Autowired
    SeckillcommodityMapper seckillcommodityMapper;

    @Override
    public IPage<SeckillCommodityBo> queryAllSeckillCommodity(Integer seckillId,String comName,Integer currentPage,Integer pageSize) {
        return seckillcommodityMapper.queryAllSeckillCommodity(new Page<>(currentPage,pageSize),seckillId,comName);
    }

    @Override
    public List<CommodityEntity> queryInCommodityId(String commodityId) {
        return seckillcommodityMapper.queryInCommodityId(commodityId);
    }

    @Override
    public ReturnJson deleteSeckillCommodity(Integer secComId) {
        if(secComId>0){
            int returns = seckillcommodityMapper.deleteById(secComId);
            if(returns>0){
                return new ReturnJson(200,"删除成功!!!");
            }else{
                return new ReturnJson(401,"删除失败!!!");
            }
        }else{
            return new ReturnJson(401,"删除失败!!!");
        }

    }

    @Override
    public List<Seckillcommodity> addSeckillCommodity(@RequestBody List<SeckillCommodityBo> seckillCommodityBoList, Long seckillId) {
        List<Seckillcommodity> list=new ArrayList<>();
        for (int i = 0; i <seckillCommodityBoList.size() ; i++) {
            Seckillcommodity seckillCommodity = new Seckillcommodity();
            seckillCommodity.setCommodityId(seckillCommodityBoList.get(i).getComId());
            seckillCommodity.setSeckillMoney(seckillCommodityBoList.get(i).getSeckillMoney());
            seckillCommodity.setSeckillNumber(seckillCommodityBoList.get(i).getSeckillNumber());
            seckillCommodity.setSurplusNumber(seckillCommodityBoList.get(i).getSeckillNumber());
            seckillCommodity.setLimitNumber(seckillCommodityBoList.get(i).getLimitNumber());
            seckillCommodity.setSort(seckillCommodityBoList.get(i).getSort());
            seckillCommodity.setSeckillId(seckillId);
            list.add(seckillCommodity);
        }
        return list;
    }
}
