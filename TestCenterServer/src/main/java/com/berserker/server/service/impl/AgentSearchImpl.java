package com.berserker.server.service.impl;

import com.berserker.server.dao.reader.tools.AgentSearchReaderMapper;
import com.berserker.server.dao.writer.tools.AgentSearchWriterMapper;
import com.berserker.server.model.tools.*;
import com.berserker.server.service.AgentSearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author klien
 * @since  2016-08-10
 */
@Component
public class AgentSearchImpl implements AgentSearchService {

    @Autowired
    private AgentSearchReaderMapper readerMapper;
    @Autowired
    private AgentSearchWriterMapper writerMapper;

    private Logger logger = LogManager.getLogger(AgentSearchService.class);

    /**
     * 功能描述: 判断是否是总部岗位,获取相应的部门清单
     * @param isHeadQuarter - 判断是否是总部岗位, 1(是总部岗位), 其他值(默认分城市岗位)
     * @return
     */
    public List<AgentDepartmentModel> getDepartment(int isHeadQuarter) {
        logger.info("isHeadQuarter:{}", isHeadQuarter);
        try {
            List<AgentDepartmentModel> result = readerMapper.findDepartmentByIsHeadQuarter(isHeadQuarter);
            logger.info("listSize:{}", (result != null)?result.size():0);
            return result;
        }catch (Exception e){
            logger.error("Exception: {}", e.getMessage());
            return Collections.EMPTY_LIST;
        }

    }

    /**
     * 功能描述: 获取所有的分城市的名称列表
     * @return
     */
    public List<AgentCityModel> getSubCityList() {
        try {
            List<AgentCityModel> result = readerMapper.findAllCity();
            logger.info("listSize:{}", (result != null)?result.size():0);
            return result;
        }catch (Exception e){
            logger.error("Exception: {}", e.getMessage());
            return Collections.EMPTY_LIST;
        }
    }

    /**
     * 功能描述: 获取目标部门下的所有职位列表
     * @param department_code
     * @return
     */
    public List<AgentPositionModel> getPositionList(int department_code) {
        try {
            logger.info("department_code:{}", department_code);
            List<AgentPositionModel> result = readerMapper.findPositions(department_code);
            logger.info("listSize:{}", (result != null)?result.size():0);
            return result;
        }catch (Exception e){
            logger.error("Exception: {}", e.getMessage());
            return Collections.EMPTY_LIST;
        }
    }

    /**
     * 功能描述: 获取所有的账号信息
     * @param model
     * @return
     */
    public List<AgentInfoModel> getAgentInfos(AgentInfoModel model) {
        try {
            logger.info("mobile:{}, department_code:{}, position_code:{}",
                    model.getMobile(),model.getDepartment_code(),model.getPosition_code());
            List<AgentInfoModel> result = readerMapper.findAgentInfo(model);
            logger.info("listSize:{}", (result != null)?result.size():0);
            return result;
        }catch (Exception e){
            logger.error("Exception: {}", e.getMessage());
            return Collections.EMPTY_LIST;
        }
    }

    /**
     * 功能描述: 增加部门
     * @param model
     * @return
     */
    public int addDepartment(AgentDepartmentModel model) {
        try {
            logger.info("isHeadQuarter:{}, name:{}",
                    model.getIsHeadQuarter(),model.getName());
            if(readerMapper.getAgentDepartmentCount(model.getName(),model.getIsHeadQuarter()) > 0){
                logger.info("count > 0");
                return 0;
            }
            int result = writerMapper.addDepartment(model);
            logger.info("result:{}", result);
            return result;
        }catch (Exception e){
            logger.error("Exception: {}", e.getMessage());
            return -1;
        }
    }

    /**
     * 功能描述: 增加分城市
     * @param model
     * @return
     */
    public int addCity(AgentCityModel model) {
        try {
            logger.info("city_name:{}", model.getName());
            if(readerMapper.getAgentCityCount(model.getName()) > 0){
                logger.info("count > 0");
                return 0;
            }
            int result = writerMapper.addCity(model);
            logger.info("result:{}", result);
            return result;
        }catch (Exception e){
            logger.error("Exception: {}", e.getMessage());
            return -1;
        }
    }

    /**
     * 功能描述: 增加职位
     * @param model
     * @return
     */
    public int addPosition(AgentPositionModel model) {
        try {
            logger.info("name:{}, department_code:{}",
                    model.getName(),model.getDepartment_code());
            if(readerMapper.getAgentPositionCount(model.getDepartment_code(),model.getName()) > 0){
                logger.info("count > 0");
                return 0;
            }
            int result = writerMapper.addPosition(model);
            logger.info("result:{}", result);
            return result;
        }catch (Exception e){
            logger.error("Exception: {}", e.getMessage());
            return -1;
        }
    }

    /**
     * 功能描述: 增加账号信息
     * @param model
     * @return
     */
    public int addAgentInfo(AgentInfoModel model) {
        try {
            logger.info("name:{}, mobile:{},department_code:{},position_code:{},city_code:{},comment:{}",
                    model.getName(),model.getMobile(),model.getDepartment_code(),model.getPosition_code(),
                    model.getCity_code(),model.getComment());
            if(readerMapper.getAgentInfoCount(model) > 0){
                return 0;
            }
            int result = writerMapper.addAgentInfo(model);
            logger.info("result:{}", result);
            return result;
        }catch (Exception e){
            logger.error("Exception: {}", e.getMessage());
            return -1;
        }
    }


}
