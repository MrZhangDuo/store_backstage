package com.hy.store_backstage.returns.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.store_backstage.returns.entity.Returns;
import com.hy.store_backstage.returns.entity.ReturnsCommodityBo;
import com.hy.store_backstage.utils.ReturnJson;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
public interface IReturnsService extends IService<Returns> {

    IPage<ReturnsCommodityBo> queryAllReturns(Returns returns, Integer currentPage, Integer pageSize);

    ReturnJson examine(Long orderId,String orderStatus, Long returnId,String applyforStatus);

}
