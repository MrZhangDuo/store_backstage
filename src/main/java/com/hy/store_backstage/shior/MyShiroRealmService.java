package com.hy.store_backstage.shior;

import com.hy.store_backstage.user.entity.User;
import com.hy.store_backstage.user.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * @ClassName MyShiroRealmService
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/19 11:27
 * @Version 1.0
 */
public class MyShiroRealmService extends AuthorizingRealm {

    //日志
    private static final Logger log = LoggerFactory.getLogger(MyShiroRealmService.class);

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RedisTemplate redisTemplate;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // TODO 自动生成的方法存根
        String userAccount = (String)token.getPrincipal();
        log.info("token带来的数据：  "+userAccount);

        User user = userService.queryUserByUserAccount(userAccount);
        if(StringUtils.isEmpty(user)){
            return null;
        }
        log.info("从数据库中查询到的数据user：{}",user);
        Set<String> roles = userService.queryUserRole(user.getUserId());
        Set<String> permmission = userService.currentUserRolePermission(user.getUserId());
        user.setRoles(roles);
        user.setPermissions(permmission);
        redisTemplate.opsForValue().set("user",user);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                //用户对象--数据库
                user,
                //密码--数据库
                user.getUserPass(),
                //ByteSource.Util.bytes(user.getSalt()),
                //realm name
                getName()
        );
        return simpleAuthenticationInfo;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        // TODO 自动生成的方法存根
        //查询数据库获取角色和权限信息
        User user = (User) redisTemplate.opsForValue().get("user");
        log.info(user.getPermissions().toString());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(user.getRoles());
        simpleAuthorizationInfo.setStringPermissions(user.getPermissions());
        return simpleAuthorizationInfo;
    }
}