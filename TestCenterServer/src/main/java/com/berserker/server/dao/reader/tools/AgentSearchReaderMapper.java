package com.berserker.server.dao.reader.tools;

import com.berserker.server.model.tools.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public interface AgentSearchReaderMapper {
    List<AgentDepartmentModel> findDepartmentByIsHeadQuarter(@Param("isHeadQuarter") int isHeaderQuarter);
    List<AgentCityModel> findAllCity();
    List<AgentPositionModel> findPositions(@Param("department_code") int department_code);
    List<AgentInfoModel> findAgentInfo(AgentInfoModel model);
    int getAgentCityCount(@Param("city_name") String name);
    int getAgentDepartmentCount(@Param("name") String name, @Param("isHeadQuarter") int isHeadQuarter);
    int getAgentPositionCount(@Param("department_code") int department_code, @Param("name") String name);
    int getAgentInfoCount(AgentInfoModel model);
}
