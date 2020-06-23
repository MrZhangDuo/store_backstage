package com.hy.store_backstage.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import sun.plugin2.message.Message;

/**
 * @ClassName ReturnJson
 * @Description TODO
 * @Author zhangduo
 * @Date 2020/6/6 13:25
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class ReturnJson {

    private Integer code;
    private String message;
    private Object data;
    private String token;

    public ReturnJson(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ReturnJson(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
