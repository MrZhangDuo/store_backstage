package com.hy.store_backstage.permission.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.store_backstage.permission.entity.Permission;
import com.hy.store_backstage.utils.ReturnJson;

import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
public interface IPermissionService extends IService<Permission> {

    Object [] queryMyPermission(Integer roleid);

    ReturnJson updateRolePermission(Integer roleid, Integer[] permission);

}
