package com.berserker.server.dao.writer.tools;

import com.berserker.server.vo.tools.AgentCityModel;
import com.berserker.server.vo.tools.AgentDepartmentModel;
import com.berserker.server.vo.tools.AgentInfoModel;
import com.berserker.server.vo.tools.AgentPositionModel;

/**
 * @author klien
 */
public interface AgentSearchWriterMapper {
    int addCity(AgentCityModel model);
    int addDepartment(AgentDepartmentModel model);
    int addPosition(AgentPositionModel model);
    int addAgentInfo(AgentInfoModel model);
    int updateAgentInfo(AgentInfoModel model);
}
