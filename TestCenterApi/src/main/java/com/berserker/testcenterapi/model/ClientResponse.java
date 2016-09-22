package com.berserker.testcenterapi.model;

public class ClientResponse {
    private int status;
    private Object data;
    private String msg;

    public int getStatus() {
        return status;
    }

    public ClientResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ClientResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ClientResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
