package com.berserker.server.service.tools;

import com.berserker.server.model.tools.*;

import java.util.List;

/**
 * @author klien
 * @since 2016-08-10
 */
public interface AgentSearchService {
    List<AgentDepartmentModel> getDepartment(int isHeadQuarter);    //获取总部的部门和分城市的部门
    List<AgentCityModel> getSubCityList();                          //获取所有分城市的名称
    List<AgentPositionModel> getPositionList(int department_code);  //获取岗位列表
    List<AgentInfoModel> getAgentInfos(AgentInfoModel model);       //获取账号列表
    int addDepartment(AgentDepartmentModel model);
    int addCity(AgentCityModel model);
    int addPosition(AgentPositionModel model);
    int addAgentInfo(AgentInfoModel model);
}
