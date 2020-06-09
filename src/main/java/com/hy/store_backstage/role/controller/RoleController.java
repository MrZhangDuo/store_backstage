package com.hy.store_backstage.role.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.hy.store_backstage.role.entity.Role;
import com.hy.store_backstage.role.service.impl.RoleServiceImpl;
import com.hy.store_backstage.utils.ReturnJson;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.RowId;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhangduo
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/role")
@Transactional
public class RoleController {

    @Autowired
    RoleServiceImpl roleService;

    /**
     * @Author zhangduo
     * @Description //TODO 查询所有的角色
     * @Date 16:17 2020/6/7
     * @Param []
     * @return java.util.List<com.hy.store_backstage.role.entity.Role>
     **/
    @CrossOrigin
    @RequestMapping(value = "queryAllRole",method = RequestMethod.GET)
    public List<Role> queryAllRole(){
        return roleService.queryAllRole();
    }

    /**
     * @Author zhangduo
     * @Description //TODO  查询某个用户的角色
     * @Date 16:17 2020/6/7
     * @Param [uid]
     * @return java.util.List<com.hy.store_backstage.role.entity.Role>
     **/
    @CrossOrigin
    @RequestMapping(value = "queryUserMyRole",method = RequestMethod.GET)
    public List<Role> queryUserMyRole(Integer uid){
        return roleService.queryUserMyRole(uid);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 修改某个用户的角色
     * @Date 16:16 2020/6/7
     * @Param [userId, rid]
     * @return com.hy.store_backstage.utils.ReturnJson
     **/
    @CrossOrigin
    @RequestMapping(value = "updateUserRole",method = RequestMethod.GET)
    public ReturnJson updateUserRole(Integer userId,Integer [] rid){
        return roleService.updateUserRole(userId,rid);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 插入角色信息
     * @Date 16:19 2020/6/7
     * @Param []
     * @return java.util.List<com.hy.store_backstage.role.entity.Role>
     **/
    @CrossOrigin
    @RequestMapping(value = "addRole",method = RequestMethod.GET)
    public ReturnJson addRole(Role role){
        return roleService.addRole(role);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 删除角色信息
     * @Date 16:19 2020/6/7
     * @Param []
     * @return java.util.List<com.hy.store_backstage.role.entity.Role>
     **/
    @CrossOrigin
    @RequestMapping(value = "deleteRole",method = RequestMethod.GET)
    public ReturnJson deleteRole(Integer roleId){
        return roleService.deleteRole(roleId);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 查询某个角色信息
     * @Date 16:20 2020/6/7
     * @Param []
     * @return java.util.List<com.hy.store_backstage.role.entity.Role>
     **/
    @CrossOrigin
    @RequestMapping(value = "queryRoleById",method = RequestMethod.GET)
    public Role queryRoleById(Integer roleId){
        return roleService.queryRoleById(roleId);
    }

    /**
     * @Author zhangduo
     * @Description //TODO
     * @Date 16:19 2020/6/7
     * @Param []
     * @return java.util.List<com.hy.store_backstage.role.entity.Role>
     **/
    @CrossOrigin
    @RequestMapping(value = "updateRole",method = RequestMethod.GET)
    public ReturnJson updateRole(Role role){
        return roleService.updateRole(role);
    }

}
