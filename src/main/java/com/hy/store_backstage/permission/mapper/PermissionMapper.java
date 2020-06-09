package com.hy.store_backstage.permission.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.store_backstage.permission.Providers.DeleteRolePermission;
import com.hy.store_backstage.permission.Providers.QueryMyPermission;
import com.hy.store_backstage.permission.Providers.UpdateRolePermission;
import com.hy.store_backstage.permission.entity.Permission;
import com.hy.store_backstage.utils.ReturnJson;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    @SelectProvider(type = QueryMyPermission.class, method = "queryMyPermission")
    Set<Integer> queryMyPermission(Integer roleid);

    @InsertProvider(type = UpdateRolePermission.class, method = "updateRolePermission")
    Integer updateRolePermission(Integer roleid, Integer[] permission);

    @DeleteProvider(type = DeleteRolePermission.class, method = "deleteRolePermission")
    Integer deleteRolePermission(Integer roleid);

}
