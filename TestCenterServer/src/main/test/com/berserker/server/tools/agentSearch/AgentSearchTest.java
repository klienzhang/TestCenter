package com.berserker.server.tools.agentSearch;

import com.berserker.server.model.tools.AgentCityModel;
import com.berserker.server.model.tools.AgentDepartmentModel;
import com.berserker.server.model.tools.AgentInfoModel;
import com.berserker.server.model.tools.AgentPositionModel;
import com.berserker.server.service.tools.AgentSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by klien on 16/8/27.
 */
@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml"})
public class AgentSearchTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AgentSearchService service;

    @Test(enabled = false)
    public void TestGetCityList(){
        List<AgentCityModel> list = service.getSubCityList();
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getId());
            System.out.println(list.get(i).getName());
        }
    }

    @Test(enabled = false)
    public void TestGetDepartment(){
        List<AgentDepartmentModel> list = service.getDepartment(1);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getId());
            System.out.println(list.get(i).getName());
        }
    }

    @Test(enabled = false)
    public void TestGetPosition(){
        List<AgentPositionModel> list = service.getPositionList(2);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getId());
            System.out.println(list.get(i).getName());
        }
    }

    @Test(enabled = false)
    public void TestGetAgentInfo(){
        AgentInfoModel model = new AgentInfoModel();
        model.setCity_code(1);
        model.setDepartment_code(2);
        model.setPosition_code(1);
        List<AgentInfoModel> list = service.getAgentInfos(model);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getId());
            System.out.println(list.get(i).getName());
            System.out.println(list.get(i).getDepartment_code());
            System.out.println(list.get(i).getCity_code());
            System.out.println(list.get(i).getPosition_code());
            System.out.println(list.get(i).getComment());
            System.out.println(list.get(i).getDepartment_name());
            System.out.println(list.get(i).getPosition_name());
        }
    }

    @Test
    public void TestAddCity(){
        AgentCityModel model = new AgentCityModel();
        model.setName("南京");
        int result = service.addCity(model);
        System.out.println(result);
        System.out.println("--------------");
    }

    @Test(enabled = true)
    public void TestAddDepartment(){
        AgentDepartmentModel model = new AgentDepartmentModel();
        model.setName("测试小组");
        model.setIsHeadQuarter(0);
        int result = service.addDepartment(model);
        System.out.println(result);
    }
}
