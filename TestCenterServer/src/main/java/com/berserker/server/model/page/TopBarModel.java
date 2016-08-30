package com.berserker.server.model.page;

import com.berserker.testcenterapi.model.common.ChildNodeModel;

import java.util.List;

public class TopBarModel {

    private String username;
    private List<ChildNodeModel> list;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ChildNodeModel> getList() {
        return list;
    }

    public void setList(List<ChildNodeModel> list) {
        this.list = list;
    }
}
