package com.hy.store_backstage.customer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.customer.entity.Customer;
import com.hy.store_backstage.customer.mapper.CustomerMapper;
import com.hy.store_backstage.customer.service.ICustomerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

}
