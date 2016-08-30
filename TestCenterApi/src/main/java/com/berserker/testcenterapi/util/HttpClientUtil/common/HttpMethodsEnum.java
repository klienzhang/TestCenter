package com.berserker.testcenterapi.util.HttpClientUtil.common;

/**
 * Created by klien on 16/7/15.
 */
public enum HttpMethodsEnum {

    GET(0, "GET"),
    POST(1,"POST"),
    PUT(2,"PUT"),
    DELETE(3,"DELETE");

    private int code;
    private String methodName;

    private HttpMethodsEnum(int code, String methodName){
        this.code = code;
        this.methodName = methodName;
    }

    public String getHttpMethodName() {
        return this.methodName;
    }
    public int getCode() {
        return this.code;
    }
}
