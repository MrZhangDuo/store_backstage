package com.hy.store_backstage.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.store_backstage.role.Providers.DeleteUserRole;
import com.hy.store_backstage.role.Providers.UpdateUserRole;
import com.hy.store_backstage.role.Providers.QueryUserMyRole;
import com.hy.store_backstage.role.entity.Role;
import com.hy.store_backstage.utils.ReturnJson;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

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
public interface RoleMapper extends BaseMapper<Role> {

    @SelectProvider(type = QueryUserMyRole.class , method = "queryUserMyRole")
    List<Role> queryUserMyRole(Integer uid);

    @SelectProvider(type = QueryUserMyRole.class , method = "queryUserRole")
    Set<String> queryUserRole(Long uid);

    @InsertProvider(type = UpdateUserRole.class, method = "updateUserRole")
    int updateUserRole(Integer uid, Integer[] rid);

    @DeleteProvider(type = DeleteUserRole.class,method = "deleteUserRole")
    int deleteUserRole(Integer uid);

}
