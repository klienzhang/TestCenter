package daoTest;

import com.berserker.server.model.tools.ToolsLeaderList;
import com.berserker.server.model.tools.ToolsMobileMgrModel;
import com.berserker.server.service.MobileMgrService;
import com.berserker.testcenterapi.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by klien on 2016/9/2.
 */
@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml"})
public class MobileMgrDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MobileMgrService service;

    @Test(enabled = false)
    public void testInsert(){
        ToolsMobileMgrModel mobileMgrModel = new ToolsMobileMgrModel();
        mobileMgrModel.setOwner_id(1);
        mobileMgrModel.setMobile("13636466766");
        System.out.println(service.saveMobile(mobileMgrModel));
    }

    @Test(enabled = false)
    public void testUpdate(){
        ToolsMobileMgrModel mobileMgrModel = new ToolsMobileMgrModel();
        mobileMgrModel.setId(1);
        mobileMgrModel.setOwner_id(1);
        mobileMgrModel.setMobile("13636466766");
        System.out.println(service.updateMobile(mobileMgrModel));
    }

    @Test(enabled = false)
    public void testSelectLeaderList(){
//        List<ToolsLeaderList> list = service.getLeaderList();
//        for(int i = 0; i< list.size(); i++){
//            System.out.println(list.get(i).getLeader_name());
//        }
    }

    @Test
    public void testSelectMobileList(){
//        List<ToolsMobileMgrModel> list = service.getMobileList(1,1,10);
//        for(int i = 0; i< list.size(); i++){
//            System.out.println(list.get(i).getUpdate_time());
//
//        }
    }
}
