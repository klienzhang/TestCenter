package com.berserker.testcenterapi.util.HttpClientUtil.common;

import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;


public class HttpCookies {

    private HttpClientContext context ;
    private CookieStore cookieStore;

    public static HttpCookies custom(){
        return new HttpCookies();
    }

    private HttpCookies(){
        this.context = new HttpClientContext();
        this.cookieStore = new BasicCookieStore();
        this.context.setCookieStore(cookieStore);
    }

    public HttpClientContext getContext() {
        return context;
    }

    public HttpCookies setContext(HttpClientContext context) {
        this.context = context;
        return this;
    }

    public CookieStore getCookieStore() {
        return cookieStore;
    }

    public HttpCookies setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
        return this;
    }
}
