package com.berserker.server.service;

import com.berserker.testcenterapi.model.PaginatonResponse;
import com.berserker.testcenterapi.model.ClientResponse;
import com.berserker.server.model.tools.*;

/**
 * @author klien
 * @since 2016-08-10
 * @update 2016-09-05
 */
public interface AgentSearchService {
    ClientResponse addCity(AgentCityModel model);
    PaginatonResponse<AgentCityModel> getSubCityList();
    ClientResponse addDepartment(AgentDepartmentModel model);
    PaginatonResponse<AgentDepartmentModel> getDepartmentList(int isHeadQuarter);
    ClientResponse addPosition(AgentPositionModel model);
    PaginatonResponse<AgentPositionModel> getPositionList(int department_code);
    ClientResponse addAgentInfo(AgentInfoModel model);
    PaginatonResponse<AgentInfoModel> getAgentInfos(AgentInfoModel model);
}
