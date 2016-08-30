import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.berserker.testcenterapi.util.FastJsonUtil;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by klien on 16/8/27.
 */
public class JsonConvertTest {


    @Test(enabled = true)
    public void JsonTry() throws Exception {
        String jsonStr = "{\"name\":\"lss\",\"age\":\"23\",\"items\":\"lssitem\"}";
        //String jsonStr2 = "[{\"JACKIE_ZHANG\":\"张学友\",\"ANDY_LAU\":\"刘德华\",\"LIMING\":\"黎明\",\"Aaron_Kwok\":\"郭富城\"}]";
        //List<String> list = FastJsonUtil.getStringList(jsonStr2);
        //System.out.println(list.size());
        //System.out.println(list);
        ModelTry modelTry = FastJsonUtil.getSingleBean(jsonStr, ModelTry.class);
        System.out.println(modelTry);
    }

    // @Test
    public void test2(){
        String jsonStr = "{\"name\":\"lss\",\"age\":\"23\",\"items\":{\"id\":\"1\",\"name\":\"beyond\"}}";
        String jsonStr2 = "{\"employees\": [" +
                "{ \"firstName\":\"John\" , \"lastName\":\"Doe\" }," +
                "{ \"firstName\":\"Anna\" , \"lastName\":\"Smith\" }," +
                "{ \"firstName\":\"Peter\" , \"lastName\":\"Jones\" }" +
                "]" +
                ",\"JACKIE_ZHANG\":\"张学友\",\"ANDY_LAU\":\"刘德华\",\"LIMING\":\"黎明\",\"Aaron_Kwok\":\"郭富城\",\"name\":\"lss\",\"age\":\"23\",\"items\":{\"id\":\"1\",\"name\":\"beyond\"}}";
        System.out.println(jsonStr2);
        Map<String, Object> map = (Map<String, Object>) JSON.parse(jsonStr2);
        System.out.println(map.size());
        for(Map.Entry m : map.entrySet()){
            System.out.println(m.getValue().getClass());
        }
    }

    @Test(enabled = false)
    public static void main1() {
        JSONObject object1 = JSONObject.parseObject("{\"name\":\"lss\",\"age\":\"23\",\"items\":{\"id\":\"1\",\"name\":\"beyond\"}}");
        JSONObject object2 = JSONObject.parseObject("{\"name\":\"lss\",\"age\":\"23\",\"items\":{\"id\":\"12\",\"name\":\"beyond12\"}}");
        compareJson(object1, object2,null);

    }
    public static void compareJson(JSONObject json1, JSONObject json2,String key) {
        Iterator<String> i = json1.keySet().iterator();
        while (i.hasNext()) {
            key = i.next();
            compareJson(json1.get(key), json2.get(key),key);
        }
    }
    public static void compareJson(Object json1,Object json2,String key) {
        if ( json1 instanceof JSONObject ) {
            compareJson((JSONObject) json1 ,(JSONObject) json2,key);
        }else if ( json1 instanceof JSONArray) {
            compareJson((JSONArray) json1 ,(JSONArray) json2,key);
        }else if(json1 instanceof String ){
            compareJson((String) json1 ,(String) json2,key);
        }else {
            compareJson(json1.toString(), json2.toString(), key);
        }
    }
    public static void compareJson(String str1,String str2,String key) {
        if (!str1.equals(str2)) {
            System.out.println("key:"+key+",json1:"+ str1 +",json2:"+str2);
        }
    }
    public static void compareJson(JSONArray json1,JSONArray json2,String key) {
        Iterator i1= json1.iterator();
        Iterator i2= json2.iterator();
        while ( i1.hasNext()) {
            compareJson(i1.next(), i2.next(),key);
        }
    }
}
