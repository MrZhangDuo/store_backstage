package com.hy.store_backstage.returns.provider;

/**
 * @ClassName UpdateProviders
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/16 17:31
 * @Version 1.0
 */
public class UpdateProviders {
    public String examine(Long returnId,String applyforStatus){
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer.append("UPDATE RETURNS SET applyfor_status='"+applyforStatus+"' WHERE return_id="+returnId+"").toString();
    }
}
