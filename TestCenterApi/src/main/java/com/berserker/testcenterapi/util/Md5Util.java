package com.berserker.testcenterapi.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    public static String GetMD5Context(String inputContext){
        if(null == inputContext){
            return null;
        }else {
            return md5(inputContext);
        }
    }

    private static String md5(String inputContext){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            byte[] md5Bytes = md5.digest(inputContext.getBytes("UTF-8"));

            return getResult(md5Bytes);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static String getResult(byte[] mybyte) throws Exception{
        StringBuffer stringBuffer = new StringBuffer();
        for(int count = 0; count < mybyte.length; count++){
            int val = ((int) mybyte[count]) & 0xff;
            if (val < 16){
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(val));
        }

        return stringBuffer.toString();
    }
}
