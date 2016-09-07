package com.berserker.server.service;

import com.berserker.testcenterapi.model.PageResponse;
import com.berserker.testcenterapi.model.ClientResponse;
import com.berserker.server.model.tools.*;

/**
 * @author klien
 * @since 2016-08-10
 * @update 2016-09-05
 */
public interface AgentSearchService {
    ClientResponse addCity(AgentCityModel model);
    PageResponse<AgentCityModel> getSubCityList();
    ClientResponse addDepartment(AgentDepartmentModel model);
    PageResponse<AgentDepartmentModel> getDepartmentList(int isHeadQuarter);
    ClientResponse addPosition(AgentPositionModel model);
    PageResponse<AgentPositionModel> getPositionList(int department_code);
    ClientResponse addAgentInfo(AgentInfoModel model);
    PageResponse<AgentInfoModel> getAgentInfos(AgentInfoModel model);
}
