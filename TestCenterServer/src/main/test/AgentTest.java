import com.alibaba.fastjson.JSONArray;
import com.berserker.testcenterapi.util.HttpClientUtil.HttpClientUtil;
import com.berserker.testcenterapi.util.HttpClientUtil.common.HttpResult;
import com.berserker.testcenterapi.util.FastJsonUtil;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/10.
 */
public class AgentTest {

    @Test
    public void testAgent() throws Exception {
        HttpContext context = new BasicHttpContext();
        Map<String, String> map = new HashMap<String, String>();
        map.put("action","login");
        map.put("callback_url","http://uumconsole.iwjwbeta.com/UumConsole/internalLogin.do");
        map.put("username","18916054173");
        map.put("password","Aaa123");
        HttpClientUtil.post("http://uumconsole.iwjwbeta.com/UumConsole/internalLogin.do",map,context);


        HttpResult result = HttpClientUtil.get(
                "http://uumconsole.iwjwbeta.com/UumConsole/agent/department/getDepartmentList.do?teamType=19&currentPage=1&maxRows=10&cityId=0&position=0&orgType=0&status=1&agentName=&email=&mobile=&employeeId=&weixinBindState=0&workCityId=2&startJoinDate=&endJoinDate=2016-08-10&_=1470808848921",
                context);
        Map<String,Object> resultMap = FastJsonUtil.getJson2Map(result.getResult());
        JSONArray array = (JSONArray) resultMap.get("rows");
        for(int i = 0; i <  array.size(); i++){
            System.out.println(array.getJSONObject(i).get("agentName"));
            System.out.println(array.getJSONObject(i).get("cityText"));
            System.out.println(array.getJSONObject(i).get("positionNames"));
            System.out.println(array.getJSONObject(i).get("mobile"));
            System.out.println(array.getJSONObject(i).get("accountType"));
        }
    }
}
