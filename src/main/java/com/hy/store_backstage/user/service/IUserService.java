package com.hy.store_backstage.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.store_backstage.user.entity.User;
import com.hy.store_backstage.utils.ReturnJson;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
public interface IUserService extends IService<User> {

    IPage<User> queryAllUser(User user, String startPage, String total);

    ReturnJson updateUser(User user);

    ReturnJson addUser(User user);

    User queryUserById(Integer userId);

    ReturnJson deleteUser(Integer userId);
}
