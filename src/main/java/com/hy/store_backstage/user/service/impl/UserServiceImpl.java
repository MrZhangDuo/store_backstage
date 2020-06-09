package com.hy.store_backstage.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.store_backstage.user.entity.User;
import com.hy.store_backstage.user.mapper.UserMapper;
import com.hy.store_backstage.user.service.IUserService;
import com.hy.store_backstage.utils.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public IPage<User> queryAllUser(User user,String startPage,String total) {
        QueryWrapper wrapper = new QueryWrapper();
        if(!StringUtils.isEmpty(user)){
            if(!StringUtils.isEmpty(user.getUserName())){
                wrapper.like("user_name",user.getUserName());
            }
            if(!StringUtils.isEmpty(user.getUserAccount())){
                wrapper.like("user_account",user.getUserAccount());
            }
        }
        IPage<User> iPage = new Page(Integer.parseInt(startPage),Integer.parseInt(total));
        IPage<User> userIPage = userMapper.selectPage(iPage,wrapper);
        return userIPage;
    }

    @Override
    public ReturnJson updateUser(User user) {
        int returns = userMapper.updateById(user);
        if(returns>0){
            return new ReturnJson(200,"修改成功!!!");
        }else{
            return new ReturnJson(401,"修改失败!!!");
        }
    }

    @Override
    public ReturnJson addUser(User user) {
        int returns = userMapper.insert(user);
        if(returns>0){
            return new ReturnJson(200,"添加成功!!!");
        }else{
            return new ReturnJson(401,"添加失败!!!");
        }
    }

    @Override
    public User queryUserById(Integer userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public ReturnJson deleteUser(Integer userId) {
        int returns = userMapper.deleteById(userId);
        if(returns>0){
            return new ReturnJson(200,"删除成功!!!");
        }else{
            return new ReturnJson(401,"删除失败!!!");
        }
    }
}
