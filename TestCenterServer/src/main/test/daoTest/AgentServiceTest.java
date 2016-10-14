package daoTest;

import com.berserker.testcenterapi.model.PaginatonResponse;
import com.berserker.testcenterapi.model.ClientResponse;
import com.berserker.server.model.tools.AgentCityModel;
import com.berserker.server.model.tools.AgentDepartmentModel;
import com.berserker.server.service.AgentSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by klien on 2016/9/5.
 */
@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml"})
public class AgentServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AgentSearchService service;

    @Test(enabled = false)
    public void testInsertCity(){
        AgentCityModel model = new AgentCityModel();
        model.setCity_name("北京");
        ClientResponse response = service.addCity(model);
        System.out.println(response.getStatus());
    }

    @Test(enabled = false)
    public void testGetCityList(){
        PaginatonResponse<AgentCityModel> response = service.getSubCityList();
        List<AgentCityModel> list = service.getSubCityList().getRecords();
        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i).getCity_code());
            System.out.println(list.get(i).getCity_name());
        }
    }

    @Test
    public void testInsertDepartment(){
        AgentDepartmentModel model = new AgentDepartmentModel();
//        model.setName("财务部2");
//        model.setIsHeadQuarter(1);
        ClientResponse response = service.addDepartment(model);
        System.out.println(response.getStatus());
    }

    public void testGetDepartmentList(){

    }
}
