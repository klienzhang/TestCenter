package com.berserker.server.model.tools;

import java.util.Date;

/**
 * Created by klien on 16/8/27.
 */
public class AgentCityModel {
    private int id;
    private String name;
    private Date update_time;
    private int updater;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public int getUpdater() {
        return updater;
    }

    public void setUpdater(int updater) {
        this.updater = updater;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
