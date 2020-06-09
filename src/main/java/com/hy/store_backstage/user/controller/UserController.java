package com.hy.store_backstage.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.store_backstage.user.entity.User;
import com.hy.store_backstage.user.service.impl.UserServiceImpl;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    /**
     * @Author zhangduo
     * @Description //TODO 查询所有用户信息
     * @Date 13:32 2020/6/6
     * @Param
     * @return
     **/
    @CrossOrigin
    @RequestMapping(value = "queryAllUser",method = RequestMethod.GET)
    public IPage<User> queryAllUser(User user,  String startPage, String total) {
        return userService.queryAllUser(user,startPage,total);
    }

    /**
     * @Author zhangduo
     * @Description //TODO 修改用户信息
     * @Date 13:32 2020/6/6
     * @Param
     * @return
     **/
    @CrossOrigin
    @RequestMapping(value = "updateUser",method = RequestMethod.GET)
    public ReturnJson updateUser(User user) {
        return userService.updateUser(user);
    }

    /**
     * @Author zhangduo
     * @Description //TODO  添加用户信息
     * @Date 13:31 2020/6/6
     * @Param
     * @return
     **/
    @CrossOrigin
    @RequestMapping(value = "addUser",method = RequestMethod.GET)
    public ReturnJson addUser(User user) {
        return userService.addUser(user);
    }

    /**
     * @Author zhangduo
     * @Description //TODO  查询某个用户信息
     * @Date 13:31 2020/6/6
     * @Param
     * @return
     **/
    @CrossOrigin(allowCredentials="true")
    @RequestMapping(value = "queryUserById",method = RequestMethod.GET)
    public User queryUserById(Integer userId) {
        return userService.queryUserById(userId);
    }

    /**
     * @Author zhangduo
     * @Description //TODO  删除某个用户
     * @Date 16:06 2020/6/6
     * @Param
     * @return
     **/
    @CrossOrigin(allowCredentials="true")
    @RequestMapping(value = "deleteUser",method = RequestMethod.GET)
    public ReturnJson deleteUser(Integer userId) {
        return userService.deleteUser(userId);
    }

}
