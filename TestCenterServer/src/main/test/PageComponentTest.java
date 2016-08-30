import com.berserker.server.model.page.SideBarModel;
import com.berserker.server.service.page.PageComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml"})
public class PageComponentTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private PageComponentService service;

    @Test
    @Transactional
    @Rollback(value = true)
    public void testShortCut(){
        SideBarModel model = service.getSideBarElements();
        System.out.println(model.getName());
        System.out.println(model.getList());
    }
}
