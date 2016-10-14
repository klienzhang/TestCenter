package redis;

import com.berserker.server.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klien on 2016/10/10.
 */
@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml"})
public class DemoRun extends AbstractTestNGSpringContextTests {

    @Autowired
    private RedisUtil demo;

    @Test
    public void run(){
        demo.set("klien1","tassadafd");
        System.out.println(demo.get("klien1",String.class));
        demo.set("klienTest","try1");
        System.out.println(demo.get("klienTest",String.class));
        List<String> list = new ArrayList<String>();
        list.add("klien");
        list.add("kureha1");
        demo.set("list",list);
        System.out.println(demo.get("list",ArrayList.class));
//        for(String s : list1){
//            System.out.println(s);
//        }
    }
}
