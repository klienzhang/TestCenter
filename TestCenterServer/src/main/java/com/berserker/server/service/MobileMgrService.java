package com.berserker.server.service;

import com.berserker.server.model.PageResponse;
import com.berserker.server.model.SOAResponse;
import com.berserker.server.model.tools.MobileDeviceModel;
import com.berserker.server.model.tools.ToolsLeaderList;
import com.berserker.server.model.tools.ToolsMobileMgrModel;

import java.util.List;

public interface MobileMgrService {
    SOAResponse saveMobile(ToolsMobileMgrModel model);
    SOAResponse updateMobile(ToolsMobileMgrModel model);
    SOAResponse deleteMobile(ToolsMobileMgrModel model);
    PageResponse<ToolsLeaderList> getLeaderList();
    PageResponse<MobileDeviceModel> getMobileTypeList(int brand, int type);
    ToolsMobileMgrModel getMobileInfo(int id);
    PageResponse<ToolsMobileMgrModel> getMobileList(ToolsMobileMgrModel mobileMgrModel, int currentPage, int pageSize);
}
