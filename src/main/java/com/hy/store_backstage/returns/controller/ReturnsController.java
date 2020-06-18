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

    @RequestMapping("queryAllReturns")
    public IPage<ReturnsCommodityBo> queryAllReturns(Returns returns, Integer currentPage, Integer pageSize){
        return returnsService.queryAllReturns(returns,currentPage,pageSize);
    };

    @RequestMapping("examine")
    public ReturnJson examine(Long orderId,String orderStatus, Long returnId,String applyforStatus){
        return returnsService.examine(orderId,orderStatus,returnId,applyforStatus);
    }
}
