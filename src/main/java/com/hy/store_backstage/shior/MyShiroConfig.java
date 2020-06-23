package com.hy.store_backstage.shior;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class MyShiroConfig {
        private String host = "localhost";
        private int port = 6379;
        private Duration timeout;
        /**
         * Filter工厂，设置对应的过滤条件和跳转条件
         * @return ShiroFilterFactoryBean
         */
        @Bean
        public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
            ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
            shiroFilterFactoryBean.setSecurityManager(securityManager);
            // 过滤器链定义映射
            Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
            /*
             * anon:所有url都都可以匿名访问，authc:所有url都必须认证通过才可以访问;
             * 过滤链定义，从上向下顺序执行，authc 应放在 anon 下面
             * */
            filterChainDefinitionMap.put("/login/toLogin", "anon");
            filterChainDefinitionMap.put("/login/info", "anon");
            filterChainDefinitionMap.put("/user/queryAllUser", "authc");
            // 配置不会被拦截的链接 顺序判断，如果前端模板采用了thymeleaf，这里不能直接使用 ("/static/**", "anon")来配置匿名访问，必须配置到每个静态目录
            // 所有url都必须认证通过才可以访问
            filterChainDefinitionMap.put("/**", "authc");
            // 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了, 位置放在 anon、authc下面
            filterChainDefinitionMap.put("/logout", "logout");
            //filterChainDefinitionMap.put("/**", "corsAuthenticationFilter");
            shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
            //自定义过滤器
            LinkedHashMap<String, Filter> filtsMap=new LinkedHashMap<String, Filter>();
            filtsMap.put("authc",new AuthenticatingFilterOverride() );
            shiroFilterFactoryBean.setFilters(filtsMap);
            return shiroFilterFactoryBean;
        }
        /**
         * RedisSessionDAO shiro sessionDao层的实现 通过redis, 使用的是shiro-redis开源插件
         * @return RedisSessionDAO
         */
        @Bean
        public RedisSessionDAO redisSessionDAO() {
            RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
            redisSessionDAO.setRedisManager(redisManager());
            redisSessionDAO.setExpire(1800);
            return redisSessionDAO;
        }

        /**
         * 自定义sessionManager
         * @return SessionManager
         */
        @Bean
        public SessionManager sessionManager() {
            MySessionManager mySessionManager = new MySessionManager();
            mySessionManager.setSessionDAO(redisSessionDAO());
            return mySessionManager;
        }

        /**
         * 配置shiro redisManager, 使用的是shiro-redis开源插件
         * @return RedisManager
         */
        @Bean
        public RedisManager redisManager() {
            RedisManager redisManager = new RedisManager();
            redisManager.setHost(host);
            redisManager.setPort(port);
            //redisManager.setPassword("root");
            redisManager.setTimeout(36000);
            return redisManager;
        }
        /**
         * cacheManager 缓存 redis实现, 使用的是shiro-redis开源插件
         * @return RedisCacheManager
         */
        @Bean
        public RedisCacheManager cacheManager() {
            RedisCacheManager redisCacheManager = new RedisCacheManager();
            redisCacheManager.setRedisManager(redisManager());
            // 必须要设置主键名称，shiro-redis 插件用过这个缓存用户信息
            redisCacheManager.setPrincipalIdFieldName("userId");
            return redisCacheManager;
        }
        /**
         * 认证
         * 配置Shiro核心 安全管理器 SecurityManager
         * SecurityManager安全管理器：所有与安全有关的操作都会与SecurityManager交互；且它管理着所有Subject；负责与后边介绍的其他组件进行交互。（类似于SpringMVC中的DispatcherServlet控制器）
         */
        @Bean
        public SecurityManager securityManager(){
            DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
            //将自定义的realm交给SecurityManager管理
            securityManager.setRealm(myShiroRealm());
            // 自定义session管理 使用redis
            securityManager.setSessionManager(sessionManager());
            // 自定义缓存实现 使用redis
            securityManager.setCacheManager(cacheManager());
            return securityManager;
        }
        /**
         *  把我自定义的realm注册为bean不然启动的时候会报重复的异常
         *  */
        @Bean
        public MyShiroRealmService myShiroRealm() {
            MyShiroRealmService myShiroRealm = new MyShiroRealmService();
            /**
             * 引入加密方式
             */
            /*realmDemo.setCredentialsMatcher(hashedCredentialsMatcher());*/
            return myShiroRealm;
        }
        /**
         * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
         * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
         */
        @Bean
        public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
            DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
            advisorAutoProxyCreator.setProxyTargetClass(true);
            return advisorAutoProxyCreator;
        }
        /**
         * 开启aop注解支持
         *即在controller中使用 @RequiresPermissions("User/userList")
         */
        @Bean
        public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
            AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
            authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
            return authorizationAttributeSourceAdvisor;
        }
    }
