package com.hy.store_backstage.utils;

import com.hy.store_backstage.user.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.util.JedisClusterHashTagUtil;

/**
 * @ClassName GetUserInFo
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/18 16:28
 * @Version 1.0
 */
public class GetUserInFo {
    @Autowired
    RedisTemplate redisTemplate;
    public  User getUser(){
        return (User)redisTemplate.opsForValue().get("user");
    }
}
