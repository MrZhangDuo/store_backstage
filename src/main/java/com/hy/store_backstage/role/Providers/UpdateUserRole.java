package com.hy.store_backstage.role.Providers;

/**
 * @ClassName UpdateUserRole
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/6 21:46
 * @Version 1.0
 */
public class UpdateUserRole {

    public String updateUserRole(Integer uid,Integer[] rid){
        StringBuffer stringBuffer = new StringBuffer("insert into role_user values");
        for (int i = 0; i <rid.length ; i++) {
            if(rid.length-1 == i){
                stringBuffer.append(" ("+uid+","+rid[i]+")");
            }else {
                stringBuffer.append(" ("+uid+","+rid[i]+"),");
            }
        }
        return stringBuffer.toString();
    }
}
