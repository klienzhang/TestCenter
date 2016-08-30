package com.berserker.server.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author KlienZhang
 */
public class SpringApplicationContextUtil {

    private static ApplicationContext contextUtil = new ClassPathXmlApplicationContext("beans.xml");

    private SpringApplicationContextUtil(){}

    public static ApplicationContext getApplicationContext(){

        if(null == contextUtil){
            contextUtil = new ClassPathXmlApplicationContext("beans.xml");
        }
        return contextUtil;
    }

}
