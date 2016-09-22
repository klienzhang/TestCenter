package other;

import com.berserker.server.enums.BankEnum;
import com.berserker.server.util.GeneratorUtil;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by klien on 2016/9/6.
 */
public class EnumTest {

    @Test(enabled = true)
    public void testEnum(){
        String id = GeneratorUtil.idCardGenerator("Sss", 12);
        System.out.println(id);
    }
}
