package com.berserker.testcenterapi.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.StringCodec;

import java.util.List;
import java.util.Map;

/**
 * @author KlienZhang
 */
public class FastJsonUtil {

    /**
     * 把JSON数据转换成普通字符串列表
     *
     * @param jsonData
     * @return
     * @throws Exception
     */
    public static List<String> getStringList(String jsonData) {
        return JSON.parseArray(jsonData, String.class);
    }

    /**
     * 把JSON数据转换成指定的java对象
     *
     * @param jsonData
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> T getSingleBean(String jsonData, Class<T> clazz) {
        return JSON.parseObject(jsonData, clazz);
    }

    /**
     * 把JSON数据转换成指定的java对象列表
     *
     * @param jsonData
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> List<T> getBeanList(String jsonData, Class<T> clazz)
            throws Exception {
        return JSON.parseArray(jsonData, clazz);
    }

    /**
     * 把JSON数据转换成较为复杂的java对象列表
     *
     * @param jsonData
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> getBeanMapList(String jsonData)
            throws Exception {
        return JSON.parseObject(jsonData,
                new TypeReference<List<Map<String, Object>>>() {
                });
    }

    /**
     * 功能描述：将JSON数据转换成Map<String,String>对象
     * @param jsonData
     * @return
     * @throws Exception
     */
    public static Map<String,Object> getJson2Map(String jsonData) {
        return (Map<String, Object>) JSON.parse(jsonData);
    }

    /**
     * 将网络请求下来的数据用fastjson处理空的情况，并将时间戳转化为标准时间格式
     * @param result
     * @return
     */
    public static String dealResponseResult(String result) {
        result = JSONObject.toJSONString(result,
                SerializerFeature.WriteClassName,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteEnumUsingToString,
                SerializerFeature.WriteSlashAsSpecial,
                SerializerFeature.WriteTabAsSpecial);
        return result;
    }
}
