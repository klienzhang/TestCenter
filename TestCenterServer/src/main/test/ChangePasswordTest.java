import com.berserker.server.service.tools.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016/8/1.
 */
@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml"})
public class ChangePasswordTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private PasswordService service;

    @Test
    public void ChangePasswordTest(){
        System.out.println(service.changePassword("13636466766", "Aaa123", "beta"));
    }
}
