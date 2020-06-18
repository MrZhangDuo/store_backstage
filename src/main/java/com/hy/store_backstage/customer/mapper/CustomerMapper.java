package com.hy.store_backstage.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.customer.entity.Customer;
import com.hy.store_backstage.customer.entity.CustomerBo;
import com.hy.store_backstage.utils.Count;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

    @SelectProvider(type = com.hy.store_backstage.customer.provider.SelectProvider.class,method = "queryAllCustomer")
    IPage<CustomerBo> queryAllCustomer(@Param("ipage")IPage<CustomerBo>iPage,@Param(value = "customerBo") CustomerBo customerBo);

    @SelectProvider(type = com.hy.store_backstage.customer.provider.SelectProvider.class,method = "customerCountBZ")
    Count customerCountBZ();

    @SelectProvider(type = com.hy.store_backstage.customer.provider.SelectProvider.class,method = "customerCountSZ")
    Count customerCountSZ();

}
