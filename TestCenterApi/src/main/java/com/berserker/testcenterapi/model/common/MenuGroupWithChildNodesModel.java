package com.berserker.testcenterapi.model.common;

import java.util.List;

/**
 * @author klien
 */
public class MenuGroupWithChildNodesModel {
    private String group_name;
    private List<ChildNodeModel> group;

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public List<ChildNodeModel> getGroup() {
        return group;
    }

    public void setGroup(List<ChildNodeModel> group) {
        this.group = group;
    }
}
