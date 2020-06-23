package com.hy.store_backstage.permission.Providers;

/**
 * @ClassName QueryMyPermission
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/6 22:48
 * @Version 1.0
 */
public class QueryMyPermission {

    public String queryMyPermission(Integer roleid){
        StringBuffer stringBuffer = new StringBuffer("select perid from role_permission where 1=1 ");
        if( roleid > 0 ){
            stringBuffer.append(" and roleid="+roleid+"");
        }
        return stringBuffer.toString();
    }

    public String currentUserRolePermission(Long userId){
            return  new StringBuffer("select per.`purl` from role r ,permission per , role_permission rp where r.`role_id`=rp.roleid  and per.id=rp.perid and roleid in (SELECT r.role_id FROM USER u,role r ,role_user ru WHERE u.user_id= ru.uid AND r.role_id=ru.rid AND u.user_id="+userId+")") .toString();
    }
}
