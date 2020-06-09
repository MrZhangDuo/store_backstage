package com.hy.store_backstage.permission.controller;


import com.hy.store_backstage.permission.entity.Permission;
import com.hy.store_backstage.permission.entity.TreeUtil;
import com.hy.store_backstage.permission.mapper.PermissionMapper;
import com.hy.store_backstage.permission.service.impl.PermissionServiceImpl;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionServiceImpl permissionService;
    @Autowired
    PermissionMapper permissionMapper;

    @CrossOrigin
    @RequestMapping(value = "queryAllPermission" , method = RequestMethod.GET)
    public List<Permission> queryAllPermission(){
        return permissionService.queryAllPermission();
    }


//    @CrossOrigin
//    @RequestMapping(value = "queryAllPermission" , method = RequestMethod.GET)
//    public List<Permission> getparticipants(){
//        List<Permission> data = permissionMapper.selectList(null);//接收在数据库中查询到的数据
//        List<Permission> list = new ArrayList<>();//返回的最终集合，可根据自己返回类型更改。
//        List<Permission> tree = TreeUtil.getTreeList("0", data);//调用工具类，第一个参数是默认传入的顶级id，和查询出来的数据
//        return tree;
//    }

    @CrossOrigin
    @RequestMapping(value = "queryMyPermission" , method = RequestMethod.GET)
    public Object[] queryMyPermission(Integer roleid) {
        return permissionService.queryMyPermission(roleid);
    }

    @CrossOrigin
    @RequestMapping(value = "updateRolePermission" , method = RequestMethod.GET)
    public ReturnJson updateRolePermission(Integer roleid, Integer[] permission) {
        return permissionService.updateRolePermission(roleid,permission);
    }



}
