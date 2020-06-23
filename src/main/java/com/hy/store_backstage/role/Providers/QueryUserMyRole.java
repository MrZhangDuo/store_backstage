package com.hy.store_backstage.role.Providers;

/**
 * @ClassName QueryUserMyRole
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/6 16:58
 * @Version 1.0
 */
public class QueryUserMyRole {
    public String queryUserMyRole(Integer uid){
        StringBuffer stringBuffer = new StringBuffer("select rid as roleId from role_user where 1=1 ");
        if(uid > 0){
            stringBuffer.append( " and uid= "+uid+"");
        }
        return stringBuffer.toString();
    }

    public String queryUserRole(Long userId){
        StringBuffer stringBuffer = new StringBuffer("SELECT r.role_name FROM USER u,role r ,role_user ru WHERE u.user_id= ru.uid AND r.role_id=ru.rid AND 1=1 ");
        if(userId > 0){
            stringBuffer.append( " and u.user_id= "+userId+"");
        }
        return stringBuffer.toString();
    }
}
