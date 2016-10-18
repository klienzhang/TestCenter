package com.berserker.server.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Klien Zhang
 */
public class DynamicDataSourceUtil extends AbstractRoutingDataSource{

    private static ThreadLocal<String> currentDataSource = new ThreadLocal<String>();

    private static Logger logger = LogManager.getLogger(DynamicDataSourceUtil.class);

    static {
        currentDataSource.set("dev");
    }

    /**
     * 功能描述：设置动态数据库源
     * @param targetDataSource
     */
    public static void setTargetDataSource(String targetDataSource){
        if(targetDataSource != "sit" || targetDataSource != "uat" || targetDataSource != "dev"){
            targetDataSource = "dev";
        }
        currentDataSource.set(targetDataSource);
        logger.debug("setDataBase to {}", targetDataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return currentDataSource.get();
    }
}
