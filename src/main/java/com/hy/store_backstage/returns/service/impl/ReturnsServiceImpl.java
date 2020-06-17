package com.hy.store_backstage.returns.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.orders.mapper.OrdersMapper;
import com.hy.store_backstage.returns.entity.Returns;
import com.hy.store_backstage.returns.entity.ReturnsCommodityBo;
import com.hy.store_backstage.returns.mapper.ReturnsMapper;
import com.hy.store_backstage.returns.service.IReturnsService;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Service
public class ReturnsServiceImpl extends ServiceImpl<ReturnsMapper, Returns> implements IReturnsService {
    @Autowired
    ReturnsMapper returnsMapper;
    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public IPage<ReturnsCommodityBo> queryAllReturns(Returns returns, Integer currentPage, Integer pageSize) {
        return returnsMapper.queryAllReturns(new Page<>(currentPage,pageSize),returns);
    }

    @Override
    public ReturnJson examine(Long orderId,String orderStatus, Long returnId,String applyforStatus) {
        if(!StringUtils.isEmpty(orderId) && !StringUtils.isEmpty(returnId)){
            int returnsStatus = returnsMapper.examine(returnId,applyforStatus);
            int ordersStatus = ordersMapper.examine(orderId,orderStatus);
            if( returnsStatus>0 && ordersStatus>0 ){
                return new ReturnJson(200,"审核已同意!!"+orderStatus+"");
            }else{
                return new ReturnJson(404,"审核出现错误");
            }
        }else{
            int returnsStatus = returnsMapper.examine(returnId,applyforStatus);
            if(returnsStatus > 0){
                return new ReturnJson(200,"审核已拒绝");
            }else{
                return new ReturnJson(404,"审核出现错误");
            }
        }
    }
}
