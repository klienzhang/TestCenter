package com.berserker.server.enums;

import lombok.Data;

public enum ResponseEnum {
    正常(1,""),
    未知异常(-9999, "发生未知异常，请联系网站开发"),
    缺少参数(-2, "必要参数未传递，请查看接口说明");

    private ResponseEnum(int l, String s) {
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
