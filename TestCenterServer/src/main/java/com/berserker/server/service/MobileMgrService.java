package com.berserker.server.service;

import com.berserker.testcenterapi.model.PageResponse;
import com.berserker.testcenterapi.model.ClientResponse;
import com.berserker.server.model.tools.MobileDeviceModel;
import com.berserker.server.model.tools.ToolsLeaderList;
import com.berserker.server.model.tools.ToolsMobileMgrModel;

public interface MobileMgrService {
    ClientResponse saveMobile(ToolsMobileMgrModel model);
    ClientResponse updateMobile(ToolsMobileMgrModel model);
    ClientResponse deleteMobile(ToolsMobileMgrModel model);
    PageResponse<ToolsLeaderList> getLeaderList();
    PageResponse<MobileDeviceModel> getMobileTypeList(int brand, int type);
    ClientResponse getMobileInfo(int id);
    PageResponse<ToolsMobileMgrModel> getMobileList(ToolsMobileMgrModel mobileMgrModel, int currentPage, int pageSize);
}
