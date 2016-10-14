package com.berserker.server.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Klien Zhang
 */
public class DynamicDataSourceUtil extends AbstractRoutingDataSource{

    private static ThreadLocal<Integer> currentDataSource = new ThreadLocal<Integer>();

    static {
        currentDataSource.set(0);
    }

    /**
     * 功能描述：设置动态数据库源
     * @param targetDataSource
     *         1 - 测试数据库
     *         2.- Beta数据库
     *         0 - 本地数据库
     */
    public static void setTargetDataSource(int targetDataSource){
        if(targetDataSource != 1 || targetDataSource != 2 || targetDataSource != 0){
            targetDataSource = 2;
        }
        currentDataSource.set(targetDataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getCurrentDataSource();
    }

    private int getCurrentDataSource(){
        return currentDataSource.get();
    }
}
