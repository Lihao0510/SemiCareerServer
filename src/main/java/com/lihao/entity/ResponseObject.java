package com.lihao.entity;

/**
 * Created by Lihao on 2017/6/8.
 */
public class ResponseObject {

    public int status;
    public String errorMsg = "";
    public Object result = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "status=" + status +
                ", result=" + result +
                '}';
    }
}
