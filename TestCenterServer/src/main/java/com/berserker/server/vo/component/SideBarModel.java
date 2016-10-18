package com.berserker.server.vo.component;

import com.berserker.testcenterapi.model.common.MenuGroupWithChildNodesModel;

import java.util.List;

/**
 * @author klien
 */
public class SideBarModel {
    private String name;
    private List<MenuGroupWithChildNodesModel> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuGroupWithChildNodesModel> getList() {
        return list;
    }

    public void setList(List<MenuGroupWithChildNodesModel> list) {
        this.list = list;
    }
}
