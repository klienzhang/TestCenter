package ToolsTest;

import com.berserker.server.service.ToolsBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import com.berserker.server.vo.tools.IdentificationCardModel;

import java.util.List;

/**
 * Created by klien on 2016/9/22.
 */
@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml"})
public class GeneratorTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ToolsBasicService service;

    @Test
    public void testIdCardGenerator(){
        System.out.println("---------------------------------");
        System.out.println("测试获取银行列表");
        List<IdentificationCardModel> list = (List<IdentificationCardModel>) service.getBankList().getData();
        for (int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("测试生成随机银行卡号");
        String idNum = (String) service.getBankCardNum("123",5).getData();
        System.out.println(idNum);
        System.out.println("---------------------------------");
    }
}
