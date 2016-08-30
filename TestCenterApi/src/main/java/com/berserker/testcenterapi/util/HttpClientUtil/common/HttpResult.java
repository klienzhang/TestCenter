package com.berserker.testcenterapi.util.HttpClientUtil.common;

public class HttpResult {
    private boolean isExecuteSuccessfully =false;
    private int statusCode = -1;
    private String result = "";

    public HttpResult() {
    }

    public boolean isExecuteSuccessfully() {
        return isExecuteSuccessfully;
    }

    public HttpResult setExecuteSuccessfully(boolean executeSuccessfully) {
        isExecuteSuccessfully = executeSuccessfully;
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public HttpResult setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getResult() {
        return result;
    }

    public HttpResult setResult(String result) {
        this.result = result;
        return this;
    }
}
