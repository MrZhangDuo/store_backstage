package com.hy.store_backstage.customer.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.customer.entity.CustomerBo;
import com.hy.store_backstage.utils.Count;
import com.hy.store_backstage.customer.entity.Customer;
import com.hy.store_backstage.customer.mapper.CustomerMapper;
import com.hy.store_backstage.customer.service.ICustomerService;
import com.hy.store_backstage.utils.CountList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Integer> customerCountBZ() {
        return CountList.countList(customerMapper.customerCountBZ());
    }

    @Override
    public List<Integer> customerCountSZ() {
        return CountList.countList(customerMapper.customerCountSZ());
    }

    @Override
    public IPage<CustomerBo> queryAllCustomer(CustomerBo customerBo) {
        if(!StringUtils.isEmpty(customerBo.getZcTimes())){
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            customerBo.setTimes(LocalDate.parse(customerBo.getZcTimes(),dt));
        }
        return customerMapper.queryAllCustomer(new Page<CustomerBo>(customerBo.getCurrentPage(),customerBo.getPageSize()),customerBo);
    }
}
