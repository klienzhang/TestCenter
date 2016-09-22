package other;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by klien on 2016/9/13.
 * @design
 * 1. 支持Contain，和jmeter一样的办法，只要包含字符串就为真 - contain
 * 2. 原JSON对比
 * 3. 查找某些key
 */
public class JsonDiff {

    @Test
    public void ate1(){
        System.out.println("running");
    }

    @Test
    public void ConverterTest(){
        String json1 = "{\"a\":\"a\",\"b\":\"b\",\"c\":\"c\",\"des\":{\"address\":\"SHANGHAI\"},\"add2\":{\"address\":\"BEIJING\"}}";
        String json2 ="{\"id\":1,\"name\":\"klien\",\"employees\":[{ \"firstName\":\"John\" , \"lastName\":\"Doe\" },{ \"firstName\":\"Anna\" , \"lastName\":\"Smith\" },{ \"firstName\":\"Peter\" , \"lastName\":\"Jones\" }]}";
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            map =  converter(json2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("OK");
    }

    public Map<String,Object> converter(String json) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(jsonObject.get("id"));
        Map<String, Object> ret = new HashMap<String, Object>();
        for(Map.Entry<String, Object> entry: jsonObject.entrySet()){
            if(entry.getValue() instanceof String || entry.getValue() instanceof Integer){
                ret.put(entry.getKey(),entry.getValue());
            }else if(entry.getValue() instanceof JSONObject){
                ret.put(entry.getKey(), converter(entry.getValue().toString()));
            }else if(entry.getValue() instanceof JSONArray){
                List<Object> list = new ArrayList<Object>();
                for(int i = 0; i < ((JSONArray) entry.getValue()).size(); i++){
                    //System.out.println(((JSONArray) entry.getValue()).get(i));
                    list.add(converter(JSONObject.toJSONString(((JSONArray) entry.getValue()).get(i))));
                }
                ret.put(entry.getKey(),list);
            }else {
                throw new Exception("error");
            }
        }
        return ret;
    }
}
