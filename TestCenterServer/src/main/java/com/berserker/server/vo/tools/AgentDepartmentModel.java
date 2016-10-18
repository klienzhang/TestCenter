package com.berserker.server.vo.tools;

import java.util.Date;

/**
 * 测试账号管理 - 部门参数管理Model
 */
public class AgentDepartmentModel {
    private int id;
    private String name;
    private int isHeadQuarter;
    private Date update_time;
    private int updater;

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

    public int getIsHeadQuarter() {
        return isHeadQuarter;
    }

    public void setIsHeadQuarter(int isHeadQuarter) {
        this.isHeadQuarter = isHeadQuarter;
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
}
