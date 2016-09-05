package com.berserker.server.service;

import com.berserker.server.model.PageResponse;
import com.berserker.server.model.SOAResponse;
import com.berserker.server.model.tools.*;

/**
 * @author klien
 * @since 2016-08-10
 * @update 2016-09-05
 */
public interface AgentSearchService {
    SOAResponse addCity(AgentCityModel model);
    PageResponse<AgentCityModel> getSubCityList();
    SOAResponse addDepartment(AgentDepartmentModel model);
    PageResponse<AgentDepartmentModel> getDepartmentList(int isHeadQuarter);
    SOAResponse addPosition(AgentPositionModel model);
    PageResponse<AgentPositionModel> getPositionList(int department_code);
    SOAResponse addAgentInfo(AgentInfoModel model);
    PageResponse<AgentInfoModel> getAgentInfos(AgentInfoModel model);
}
