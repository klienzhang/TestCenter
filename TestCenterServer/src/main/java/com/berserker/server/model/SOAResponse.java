package com.berserker.server.model;

public class SOAResponse {
    private int status;
    private Object data;
    private int errCode;
    private Object errData;

    public Object getErrData() {
        return errData;
    }

    public void setErrData(Object errData) {
        this.errData = errData;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
