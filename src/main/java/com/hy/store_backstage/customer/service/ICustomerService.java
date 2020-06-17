package com.hy.store_backstage.customer.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.store_backstage.customer.entity.Customer;
import com.hy.store_backstage.customer.entity.CustomerBo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
public interface ICustomerService extends IService<Customer> {

    IPage<CustomerBo> queryAllCustomer(CustomerBo customerBo);
    List<Integer> customerCountBZ();
    List<Integer> customerCountSZ();

}
