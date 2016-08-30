package com.berserker.testcenterapi.util.HttpClientUtil.HCB;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * Custom HttpClientBuilder Factory
 */
public class HCB extends HttpClientBuilder {

    private HCB(){}

    public static HCB custom(){
        return new HCB();
    }

    public HCB setTimeOut(final int timeOut){
        RequestConfig config = RequestConfig.custom().setConnectTimeout(timeOut)
                .setConnectionRequestTimeout(timeOut)
                .setSocketTimeout(timeOut)
                .build();
        return (HCB) this.setDefaultRequestConfig(config);
    }

    public HCB setProxy(String hostOrIP, int port){
        HttpHost proxy = new HttpHost(hostOrIP, port, "http");
        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
        return (HCB) this.setRoutePlanner(routePlanner);
    }

    public HCB setPool(int maxTotal, int defaultMaxPerRoute){
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                .<ConnectionSocketFactory> create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        connManager.setMaxTotal(maxTotal);
        connManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        //isSetPool=true;
        return (HCB) this.setConnectionManager(connManager);
    }
}
