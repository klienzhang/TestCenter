import com.berserker.server.model.WelcomeNoticeResponse;
import com.berserker.server.service.WelcomepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import java.util.List;

@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml"})
public class WelcomeTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private WelcomepageService service;

    @Test
    @Transactional
    @Rollback(value = true)
    public void testShortCut(){
        List<WelcomeNoticeResponse> list = service.getNotice();
        if(list != null){
            for(int i = 0; i<list.size(); i++){
                System.out.println(list.get(i).getTitle());
                System.out.println(list.get(i).getContent());
            }
        }
    }
}
