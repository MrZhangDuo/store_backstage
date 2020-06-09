package com.hy.store_backstage.role.Providers;

/**
 * @ClassName QueryMyPermission
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/6 22:48
 * @Version 1.0
 */
public class DeleteUserRole {

    public String deleteUserRole(Integer uid){
        StringBuffer stringBuffer = new StringBuffer("delete from role_user where 1=1 ");
        if( uid > 0 ){
            stringBuffer.append(" and uid="+uid+"");
        }
        return stringBuffer.toString();
    }
}
