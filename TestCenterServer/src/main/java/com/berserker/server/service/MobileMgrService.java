package com.berserker.server.service;

import com.berserker.server.model.PageResponse;
import com.berserker.server.model.tools.ToolsLeaderList;
import com.berserker.server.model.tools.ToolsMobileMgrModel;

import java.util.List;

public interface MobileMgrService {
    int saveMobile(ToolsMobileMgrModel model);
    int updateMobile(ToolsMobileMgrModel model);
    int deleteMobile(ToolsMobileMgrModel model);
    PageResponse<ToolsMobileMgrModel> getMobileList(int leader_id, int currentPage, int pageSize);
    List<ToolsLeaderList> getLeaderList();
    ToolsMobileMgrModel getMobileInfo(int id);
}
