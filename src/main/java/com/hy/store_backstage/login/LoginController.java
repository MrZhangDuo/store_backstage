package com.hy.store_backstage.login;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSONObject;
import com.hy.store_backstage.user.entity.User;
import com.hy.store_backstage.user.service.impl.UserServiceImpl;
import com.hy.store_backstage.utils.GetUserInFo;
import com.hy.store_backstage.utils.ReturnJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/17 15:00
 * @Version 1.0
 */
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RedisTemplate redisTemplate;

//    @PostMapping("toLogin")
//    public ReturnJson toLogin(@RequestBody User user){
//        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserAccount(),user.getUserPass());
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(token);
//            return new ReturnJson(20000,"登录成功",(User)subject.getPrincipal());
//        }catch (AuthenticationException e) {
//            e.printStackTrace();
//            return new ReturnJson(-1, "用户名或密码不正确");
//        }
//
//    }


    @PostMapping("/toLogin")
    public ReturnJson login(@RequestBody User user) {
        UsernamePasswordToken tokens = new UsernamePasswordToken(user.getUserAccount(),user.getUserPass());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(tokens);
            Session session = subject.getSession();
            String token = (String) session.getId();
            return new ReturnJson(20000,"登录成功",(User)subject.getPrincipal(),token);
        }catch (AuthenticationException e) {
            e.printStackTrace();
            return new ReturnJson(-1, "用户名或密码不正确");
        }
    }

    @GetMapping("info")
    public ReturnJson info(){
        User user1 = (User)redisTemplate.opsForValue().get("user");
        return new ReturnJson(20000,"success",user1);
    }

    @PostMapping("/logout")
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();

        String sessionId = (String)session.getId();
        logger.info("sessionId{}",sessionId);
        JedisShardInfo shardInfo = new JedisShardInfo("redis://127.0.0.1:6379");
        shardInfo.setPassword("root");
        Jedis jedis = new Jedis(shardInfo);
        long jedis_key = jedis.del("shiro:session:"+sessionId);
        logger.info("jedis_key{}",jedis_key);
        logger.info("--------数据已经删除--------");

    }


}
