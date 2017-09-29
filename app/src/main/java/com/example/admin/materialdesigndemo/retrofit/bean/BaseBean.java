package com.example.admin.materialdesigndemo.retrofit.bean;

/**
 * Created by zq on 2017/9/28.
 */

public class BaseBean {

    private String time;
    private boolean success;
    private String code;
    private String info;
    private String requestId;
    private String bizRequestId;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getBizRequestId() {
        return bizRequestId;
    }

    public void setBizRequestId(String bizRequestId) {
        this.bizRequestId = bizRequestId;
    }
}
