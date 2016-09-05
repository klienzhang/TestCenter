package com.berserker.server.model.tools;

import com.berserker.testcenterapi.util.DateUtil;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by klien on 16/9/1.
 */
public class ToolsMobileMgrModel {
    private int id;
    private String mobile;
    private int owner_id;
    private String type;
    private String owner_name;
    private String user;
    private Timestamp update_time;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUpdate_time() {
        return DateUtil.dateToString(update_time, DateUtil.DATETIME_FORMAT);
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
