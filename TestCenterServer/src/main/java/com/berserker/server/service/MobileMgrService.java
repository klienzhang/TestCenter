package com.berserker.server.service;

import com.berserker.server.model.tools.ToolsLeaderList;
import com.berserker.server.model.tools.ToolsMobileMgrModel;

import java.util.List;

public interface MobileMgrService {
    int saveMobile(ToolsMobileMgrModel model);
    int updateMobile(ToolsMobileMgrModel model);
    int deleteMobile(ToolsMobileMgrModel model);
    List<ToolsMobileMgrModel> getMobileList(int leader_id);
    List<ToolsLeaderList> getLeaderList();
}
