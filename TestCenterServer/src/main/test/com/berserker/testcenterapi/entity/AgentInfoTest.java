package com.berserker.testcenterapi.entity;

import com.berserker.server.model.tools.ToolsAgentMaintenanceRequest;
import com.berserker.server.model.tools.ToolsAgentMaintenanceResponse;
import com.berserker.server.service.tools.AgentSearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/8/1.
 */
@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml"})
public class AgentInfoTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private AgentSearchService service;

    private Logger logger = LogManager.getLogger(AgentInfoTest.class);

//    @Test(enabled = false)
//    public void getAgentInfoListTest(){
//        ToolsAgentMaintenanceRequest request = new ToolsAgentMaintenanceRequest();
//        request.setPageNum(1);
//        request.setPageSize(2);
//        request.setDepartment_id(3);
//        request.setCity_id(12438);
//        request.setPosition_id(8);
//        List<ToolsAgentMaintenanceResponse> responses = service.getAgentInfo(request);
//        System.out.println((responses != null) ? responses.size(): 0);
//    }
//
//    @Test(enabled = true)
//    public void updateOrSaveTest(){
//        ToolsAgentMaintenanceRequest request = new ToolsAgentMaintenanceRequest();
//        request.setMobile("13636466776");
//        request.setName("张琪");
//        request.setCity_id(2);
//        request.setDepartment_id(10);
//        request.setPosition_id(11);
//        System.out.println(service.updateOrSaveMobile(request));
//    }
//
//    @Test(enabled = false)
//    public void deleteMobile(){
//        System.out.println(service.deleteMobile("123123"));
//        System.out.println(service.deleteMobile("13691116676"));
//    }
}
