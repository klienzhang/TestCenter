package com.berserker.server.service.impl;

import com.berserker.server.dao.reader.tools.AgentSearchReaderMapper;
import com.berserker.server.dao.writer.tools.AgentSearchWriterMapper;
import com.berserker.server.model.PageResponse;
import com.berserker.server.model.SOAResponse;
import com.berserker.server.model.tools.*;
import com.berserker.server.service.AgentSearchService;
import com.berserker.server.util.ResponseUtil;
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
     * 功能描述: 增加分城市
     * @param model
     * @return
     */
    public SOAResponse addCity(AgentCityModel model) {
        SOAResponse response = new SOAResponse();
        try{
            //如果已有城市，则不插入
            if(readerMapper.getCityList(model).size() > 0){
                response.setStatus(0);
                response.setMsg("existed data");
                return response;
            }
            int result = writerMapper.addCity(model);
            response.setStatus(result);
            response.setMsg("Success");
        }catch (Exception e){
            e.printStackTrace();
            response.setStatus(-1);
            response.setMsg("Exception Occur");
        }
        return response;
    }

    /**
     * 功能描述: 获取所有的分城市的名称列表
     * @return
     */
    public PageResponse<AgentCityModel> getSubCityList() {

        PageResponse<AgentCityModel> response = null;
        try{
            List<AgentCityModel> list = readerMapper.getCityList(new AgentCityModel());
            response = ResponseUtil.list2PageResponse(list);
        }catch (Exception e){
            response = ResponseUtil.list2PageResponse(Collections.EMPTY_LIST);
        }
        return response;
    }

    /**
     * 功能描述: 增加部门
     * @param model
     * @return
     */
    public SOAResponse addDepartment(AgentDepartmentModel model) {
        SOAResponse response = new SOAResponse();
        try {
            if(readerMapper.getDepartmentList(model).size() > 0){
                response.setStatus(0);
                response.setMsg("existed data");
                return response;
            }
            int result = writerMapper.addDepartment(model);
            response.setStatus(result);
            response.setMsg("Success");
        }catch (Exception e){
            response.setStatus(-1);
            response.setMsg("Exception Occur");
        }

        return response;
    }

    /**
     * 功能描述: 判断是否是总部岗位,获取相应的部门清单
     * @param isHeadQuarter - 判断是否是总部岗位, 1(是总部岗位), 其他值(默认分城市岗位)
     * @return
     */
    public PageResponse<AgentDepartmentModel> getDepartmentList(int isHeadQuarter) {
        PageResponse<AgentDepartmentModel> response = null;
        try{
            AgentDepartmentModel model = new AgentDepartmentModel();
            model.setIsHeadQuarter(isHeadQuarter);
            List<AgentDepartmentModel> list = readerMapper.getDepartmentList(model);
            response = ResponseUtil.list2PageResponse(list);
        }catch (Exception e){
            response = ResponseUtil.list2PageResponse(Collections.EMPTY_LIST);
        }
        return response;
    }

    /**
     * 功能描述: 增加职位
     * @param model
     * @return
     */
    public SOAResponse addPosition(AgentPositionModel model) {
        SOAResponse response = new SOAResponse();
        try {
            if(readerMapper.getPositionList(model).size() > 0){
                response.setStatus(0);
                response.setMsg("existed data");
                return response;
            }
            int result = writerMapper.addPosition(model);
            response.setStatus(result);
            response.setMsg("Success");
        }catch (Exception e){
            response.setStatus(-1);
            response.setMsg("Exception Occur");
        }

        return response;
    }

    /**
     * 功能描述: 获取目标部门下的所有职位列表
     * @param department_code
     * @return
     */
    public PageResponse<AgentPositionModel> getPositionList(int department_code) {
        PageResponse<AgentPositionModel> response = null;
        try{
            AgentPositionModel model = new AgentPositionModel();
            model.setDepartment_code(department_code);
            List<AgentPositionModel> list = readerMapper.getPositionList(model);
            response = ResponseUtil.list2PageResponse(list);
        }catch (Exception e){
            response = ResponseUtil.list2PageResponse(Collections.EMPTY_LIST);
        }
        return response;
    }

    /**
     * 功能描述: 增加账号信息
     * @param model
     * @return
     */
    public SOAResponse addAgentInfo(AgentInfoModel model) {
        SOAResponse response = new SOAResponse();
        try {
            if(readerMapper.getAgentInfoList(model).size() > 0){
                response.setStatus(0);
                response.setMsg("existed data");
                return response;
            }
            int result = writerMapper.addAgentInfo(model);
            response.setStatus(result);
            response.setMsg("Success");
        }catch (Exception e){
            response.setStatus(-1);
            response.setMsg("Exception Occur");
        }
        return response;
    }

    /**
     * 功能描述: 获取所有的账号信息
     * @param model
     * @return
     */
    public PageResponse<AgentInfoModel> getAgentInfos(AgentInfoModel model) {
        PageResponse<AgentInfoModel> response = null;
        try{
            List<AgentInfoModel> list = readerMapper.getAgentInfoList(model);
            response = ResponseUtil.list2PageResponse(list);
        }catch (Exception e){
            response = ResponseUtil.list2PageResponse(Collections.EMPTY_LIST);
        }
        return response;
    }
}
