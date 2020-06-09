package com.hy.store_backstage.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.store_backstage.role.entity.Role;
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
public interface IRoleService extends IService<Role> {

    List<Role> queryAllRole();

    List<Role> queryUserMyRole(Integer uid);

    ReturnJson updateUserRole(Integer uid, Integer [] rid);

    ReturnJson addRole(Role role);

    ReturnJson updateRole(Role role);

    ReturnJson deleteRole(Integer roleId);

    Role queryRoleById(Integer roleId);
}
