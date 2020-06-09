package com.hy.store_backstage.permission.Providers;

/**
 * @ClassName UpdateRolePermission
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/8 10:04
 * @Version 1.0
 */
public class UpdateRolePermission {

    public String updateRolePermission(Integer roleid,Integer[] permission){
        StringBuffer stringBuffer = new StringBuffer("insert into role_permission values");
        for (int i = 0; i <permission.length ; i++) {
            if(permission.length-1 == i){
                stringBuffer.append(" ("+permission[i]+","+roleid+")");
            }else {
                stringBuffer.append(" ("+permission[i]+","+roleid+"),");
            }
        }
        return stringBuffer.toString();
    }
}
