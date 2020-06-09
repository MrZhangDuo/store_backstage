package com.hy.store_backstage.permission.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.permission.entity.Permission;
import com.hy.store_backstage.permission.mapper.PermissionMapper;
import com.hy.store_backstage.permission.service.IPermissionService;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    public List<Permission> queryAllPermission(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.isNull("pid");
        return queryPermission(permissionMapper.selectList(wrapper));
    }

    public List<Permission> queryPermission(List<Permission> permissionBoList){
        for (Permission permission1 : permissionBoList){
            List<Permission> permissionList = queryXiaJi(permission1.getId());
            permission1.setChildren(permissionList);
            queryPermission(permissionList);
        }
        return permissionBoList;
    }

    public List<Permission> queryXiaJi(Integer id){
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("pid",id);//109
            return permissionMapper.selectList(wrapper);//110 114
    }

    @Override
    public Object[] queryMyPermission(Integer roleid) {
        return   permissionMapper.queryMyPermission(roleid).toArray();
    }

    @Override
    public ReturnJson updateRolePermission(Integer roleid, Integer[] permission) {
        int delete = permissionMapper.deleteRolePermission(roleid);
        if(permission.length > 0){
            int returns = permissionMapper.updateRolePermission(roleid,permission);
        }
        return new ReturnJson(200,"分配权限成功");
    }
}
