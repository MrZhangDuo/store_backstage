package com.hy.store_backstage.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.store_backstage.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
