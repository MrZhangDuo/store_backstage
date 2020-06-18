package com.hy.store_backstage.customer.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.customer.entity.CustomerBo;
import com.hy.store_backstage.customer.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;

    @RequestMapping("queryAllCustomer")
    public IPage<CustomerBo> queryAllCustomer(CustomerBo customerBo){
        return customerService.queryAllCustomer(customerBo);
    }

    @RequestMapping("customerCountBZ")
    public List<Integer> customerCountBZ() {
        return customerService.customerCountBZ();
    }

    @RequestMapping("customerCountSZ")
    public List<Integer> customerCountSZ() {
        return customerService.customerCountSZ();
    }

}
