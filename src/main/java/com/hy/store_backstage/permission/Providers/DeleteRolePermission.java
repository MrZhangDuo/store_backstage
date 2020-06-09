package com.hy.store_backstage.permission.Providers;

/**
 * @ClassName QueryMyPermission
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/6 22:48
 * @Version 1.0
 */
public class DeleteRolePermission {

    public String deleteRolePermission(Integer roleid){
        StringBuffer stringBuffer = new StringBuffer("delete from role_permission where 1=1 ");
        if( roleid > 0 ){
            stringBuffer.append(" and roleid="+roleid+"");
        }
        return stringBuffer.toString();
    }
}
