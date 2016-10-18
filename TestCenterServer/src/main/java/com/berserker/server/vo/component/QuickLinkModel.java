package com.berserker.server.vo.component;

import com.berserker.testcenterapi.model.common.ChildNodeModel;

import java.util.List;

/**
 * @author klien
 */
public class QuickLinkModel {

    private String barName;
    private List<ChildNodeModel> list;

    public QuickLinkModel() {}

    public QuickLinkModel(String barName, List<ChildNodeModel> list) {
        this.barName = barName;
        this.list = list;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public List<ChildNodeModel> getList() {
        return list;
    }

    public void setList(List<ChildNodeModel> list) {
        this.list = list;
    }
}
