package com.berserker.server.dao.reader.common;

import com.berserker.testcenterapi.model.common.ChildNodeModel;
import com.berserker.testcenterapi.model.common.MenuGroupWithChildNodesModel;

import java.util.List;

/**
 * @author Klien Zhang
 */
public interface PageComponentReaderMaper {
    List<ChildNodeModel> getQuickLinkElements();
    String getTopBarElements();
    List<MenuGroupWithChildNodesModel> getSideBar();
}
