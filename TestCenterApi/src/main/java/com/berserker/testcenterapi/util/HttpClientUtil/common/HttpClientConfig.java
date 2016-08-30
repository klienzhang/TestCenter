package com.berserker.testcenterapi.util.HttpClientUtil.common;

import org.apache.http.Header;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HttpContext;

/**
 * @author  KlienZhang
 * @date    2016-07-19
 * HttpClient Object Collections
 */
public class HttpClientConfig {

    private CloseableHttpClient httpClient;
    private String url;
    private HttpContext httpContext;
    private Header[] header;
    private Object entityContents;
    private HttpMethodsEnum method;
    private String inenc;       //Encoding for Setting HttpEntity
    private String onenc;       //Encoding for getting HttpEntity

    private HttpClientConfig(){}

    public static HttpClientConfig custom(){
        return new HttpClientConfig();
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public HttpClientConfig setHttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public HttpClientConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public HttpContext getHttpContext() {
        return httpContext;
    }

    public HttpClientConfig setHttpContext(HttpContext httpContext) {
        this.httpContext = httpContext;
        return this;
    }

    public Header[] getHeader() {
        return header;
    }

    public HttpClientConfig setHeader(Header[] header) {
        this.header = header;
        return this;
    }

    public Object getEntityContents() {
        return entityContents;
    }

    public HttpClientConfig setEntityContents(Object entityContents) {
        this.entityContents = entityContents;
        return this;
    }

    public HttpMethodsEnum getMethod() {
        return method;
    }

    public HttpClientConfig setMethod(HttpMethodsEnum method) {
        this.method = method;
        return this;
    }

    public String getInenc() {
        return inenc;
    }

    public HttpClientConfig setInenc(String inenc) {
        this.inenc = inenc;
        return this;
    }

    public String getOnenc() {
        return onenc;
    }

    public HttpClientConfig setOnenc(String onenc) {
        this.onenc = onenc;
        return this;
    }
}
