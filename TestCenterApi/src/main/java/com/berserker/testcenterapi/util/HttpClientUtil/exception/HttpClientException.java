package com.berserker.testcenterapi.util.HttpClientUtil.exception;

/**
 * @author      klienzhang
 * @date        2016-07-15
 * @version     1.0
 */
public class HttpClientException extends Exception {

    /**
     * Get HttpClientException
     * @param e
     */
    public HttpClientException(Exception e){
        super(e);
    }

    /**
     * Get HttpClientException
     * @param message
     */
    public HttpClientException(String message){
        super(message);
    }

    /**
     * Get HttpClientException
     * @param e
     * @param message
     */
    public HttpClientException(Exception e, String message){
        super(message,e);
    }

}
