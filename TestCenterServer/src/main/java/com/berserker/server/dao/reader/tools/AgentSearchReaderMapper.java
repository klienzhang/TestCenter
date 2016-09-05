package com.berserker.server.dao.reader.tools;

import com.berserker.server.model.tools.AgentCityModel;
import com.berserker.server.model.tools.*;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public interface AgentSearchReaderMapper {
    List<AgentCityModel> getCityList(AgentCityModel model);
    List<AgentDepartmentModel> getDepartmentList(AgentDepartmentModel model);
    List<AgentPositionModel> getPositionList(AgentPositionModel model);
    List<AgentInfoModel> getAgentInfoList(AgentInfoModel model);
}
