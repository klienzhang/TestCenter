package com.berserker.server.util;

public class RequestConverter {

    public static int string2Integer(String source){
        int target;
        try{
            target = Integer.valueOf(source);
        }catch (Exception e){
            target = -1;
        }
        return target;
    }
}
