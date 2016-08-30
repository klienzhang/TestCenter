package com.berserker.testcenterapi.util;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author klien
 */
public class PropertiesUtil {

    /**
     *  功能描述： 打印所有的系统属性
     */
    public static void printAllSystemProperties(){
        Properties pps = System.getProperties();
        pps.list(System.out);
    }

    /**
     * 功能描述： 获取Properties文件中某一个Key值
     * @param filePath
     * @param key
     * @return
     *      1. Value值
     *      2. null
     */
    public static String getValueByValue(String filePath, String key){
        Properties pps = new Properties();
        InputStream in = null;
        try{
            in = PropertiesUtil.class.getResourceAsStream(filePath);
//            in = new BufferedInputStream(new FileInputStream(filePath));
            pps.load(in);
            return pps.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    /**
     * 功能描述： 打印properties文件中的所有属性
     * @param filePath
     */
    public static void printAllProperties(String filePath){
        Properties pps = new Properties();
        try {
            pps.load(new FileInputStream(filePath));
            Enumeration enum1 = pps.propertyNames();
            while (enum1.hasMoreElements()) {
                String strKey = (String) enum1.nextElement();
                String strValue = pps.getProperty(strKey);
                System.out.println(strKey + "=" + strValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能描述：
     * @param filePath
     * @param key
     * @param value
     */
    public static void writeProperties(String filePath, String key, String value){
        Properties pps = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
            pps.load(in);
            pps.setProperty(key,value);
            pps.store(new FileOutputStream(filePath),"update "+ key + " value");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
