package com.hy.store_backstage.returns.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.returns.entity.Returns;
import com.hy.store_backstage.returns.entity.ReturnsCommodityBo;
import com.hy.store_backstage.returns.service.impl.ReturnsServiceImpl;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/returns")
@CrossOrigin
public class ReturnsController {
    @Autowired
    ReturnsServiceImpl returnsService;

    /**
     * @Author zhangduo
     * @Description //TODO 查询所有退(换)款的商品
     * @Date 10:20 2020/6/17
     * @Param [returns, currentPage, pageSize]
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.hy.store_backstage.returns.entity.ReturnsCommodityBo>
     **/
    @RequestMapping("queryAllReturns")
    public IPage<ReturnsCommodityBo> queryAllReturns(Returns returns, Integer currentPage, Integer pageSize){
        return returnsService.queryAllReturns(returns,currentPage,pageSize);
    };

    /**
     * @Author zhangduo
     * @Description //TODO 审核按钮 同意||拒绝
     * @Date 10:20 2020/6/17
     * @Param [orderId, orderStatus, returnId, applyforStatus]
     * @return com.hy.store_backstage.utils.ReturnJson
     **/
    @RequestMapping("examine")
    public ReturnJson examine(Long orderId,String orderStatus, Long returnId,String applyforStatus){
        return returnsService.examine(orderId,orderStatus,returnId,applyforStatus);
    }
}
