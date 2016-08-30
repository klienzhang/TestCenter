package com.berserker.server.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Klien Zhang
 */
public class DynamicDataSourceUtil extends AbstractRoutingDataSource{

    private static ThreadLocal<String> currentDataSource = new ThreadLocal<String>();
    private final static String defaultDataSource = "dev";

    /**
     * 功能描述：设置动态数据库源
     * @param targetDataSource
     *         1. sit - 测试数据库
     *         2. uat - Beta数据库
     *         3. dev - 开发数据库
     */
    public static void setTargetDataSource(String targetDataSource){
        (targetDataSource = (targetDataSource == null) ? defaultDataSource : targetDataSource).trim().toLowerCase();
        if(targetDataSource.equals("sit")){
            currentDataSource.set("sit");
        }else if(targetDataSource.equals("uat")){
            currentDataSource.set("uat");
        }else {
            currentDataSource.set("dev");
        }
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getCurrentDataSource();
    }

    private String getCurrentDataSource(){
        String ds = currentDataSource.get();
        return (ds == null) ? defaultDataSource : ds;
    }
}
