package com.berserker.server.util.timer;

import com.berserker.server.constants.ValueConstant;
import com.berserker.server.service.WelcomepageService;
import com.berserker.testcenterapi.util.PropertiesUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author klien
 * @since 2016-08-26
 */
@Component("orderTask")
@Lazy(false)
public class OrderTask {

    @Autowired
    private WelcomepageService welcomepageService;

    private Logger logger = LogManager.getLogger(OrderTask.class);

    @Scheduled(fixedRate = 600000)
    public void updateDomain(){
        //初始化domain缓存
        String configFilePath = "/properties/config.properties";
        ValueConstant.DOMAIN_CONFIG = PropertiesUtil.getValueByValue(configFilePath,"env.domain");
        logger.info("Auto Update Domain:{}", ValueConstant.DOMAIN_CONFIG);

        //初始化首页公告list
        ValueConstant.NOTICE_LIST = welcomepageService.getNotice();
        logger.info("Auto Update Notice_list, Size is:{}", (ValueConstant.NOTICE_LIST!=null)?ValueConstant.NOTICE_LIST.size():0);
        //初始化首页项目进度list
        ValueConstant.PROGRESS_LIST = welcomepageService.getProjectProgress();
        logger.info("Auto Update Progress_list, Size is:{}", (ValueConstant.PROGRESS_LIST!=null)?ValueConstant.PROGRESS_LIST.size():0);
    }


}
