package com.hy.store_backstage.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.role.entity.Role;
import com.hy.store_backstage.role.mapper.RoleMapper;
import com.hy.store_backstage.role.service.IRoleService;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> queryAllRole() {
        return roleMapper.selectList(null);
    }

    @Override
    public List<Role> queryUserMyRole(Integer uid) {
        return roleMapper.queryUserMyRole(uid);
    }

    @Override
    public ReturnJson updateUserRole(Integer uid, Integer[] rid) {
        int delete = roleMapper.deleteUserRole(uid);
        if(rid.length > 0){
            int returns = roleMapper.updateUserRole(uid,rid);
        }
        return new ReturnJson(200,"分配角色成功");
    }

    @Override
    public ReturnJson addRole(Role role) {
        role.setAvailable(1L);
        int returns = roleMapper.insert(role);
        if(returns>0){
            return new ReturnJson(200,"添加成功");
        }else{
            return new ReturnJson(401,"添加失败");
        }
    }

    @Override
    public Role queryRoleById(Integer roleId) {
        return roleMapper.selectById(roleId);
    }

    @Override
    public ReturnJson updateRole(Role role) {
        int returns = roleMapper.updateById(role);
        if(returns>0){
            return new ReturnJson(200,"修改成功");
        }else{
            return new ReturnJson(401,"修改失败");
        }
    }

    @Override
    public ReturnJson deleteRole(Integer roleId) {
        int returns = roleMapper.deleteById(roleId);
        if(returns>0){
            return new ReturnJson(200,"删除成功");
        }else{
            return new ReturnJson(401,"删除失败");
        }
    }

}
