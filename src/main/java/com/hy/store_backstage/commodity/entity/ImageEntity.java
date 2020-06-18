package com.hy.store_backstage.commodity.entity;

import java.io.Serializable;

public class ImageEntity implements Serializable {

    //判断结果
    private boolean success;
    //返回信息
    private String message;

    public ImageEntity(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ImageEntity{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
