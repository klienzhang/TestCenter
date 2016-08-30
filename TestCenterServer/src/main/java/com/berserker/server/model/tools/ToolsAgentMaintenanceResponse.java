package com.berserker.server.model.tools;

import java.util.Date;

/**
 * @author klien
 * @since 2016-08-17
 */
public class ToolsAgentMaintenanceResponse {
    private int id;
    private String mobile;
    private String name;
    private int department_type;
    private int agent_type;
    private int agent_city;
    private int updater;
    private Date update_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUpdater() {
        return updater;
    }

    public void setUpdater(int updater) {
        this.updater = updater;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartment_type() {
        return department_type;
    }

    public void setDepartment_type(int department_type) {
        this.department_type = department_type;
    }

    public int getAgent_type() {
        return agent_type;
    }

    public void setAgent_type(int agent_type) {
        this.agent_type = agent_type;
    }

    public int getAgent_city() {
        return agent_city;
    }

    public void setAgent_city(int agent_city) {
        this.agent_city = agent_city;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
