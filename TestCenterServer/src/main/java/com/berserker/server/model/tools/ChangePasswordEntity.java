package com.berserker.server.model.tools;

/**
 * 功能描述：用于修改密码服务
 *
 * @author klien
 */
public class ChangePasswordEntity {

    private String mobile;
    private String password;
    private String currenttime;

    public String getDate() {
        return currenttime;
    }

    public void setDate(String currenttime) {
        this.currenttime = currenttime;
    }

    public ChangePasswordEntity() {
    }

    public ChangePasswordEntity(String mobile, String password, String currenttime) {
        this.mobile = mobile;
        this.password = password;
        this.currenttime = currenttime;
    }

    public String getMobile() {
        return mobile;
    }

    public ChangePasswordEntity setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ChangePasswordEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getCurrenttime() {
        return currenttime;
    }

    public ChangePasswordEntity setCurrenttime(String currenttime) {
        this.currenttime = currenttime;
        return this;
    }
}
