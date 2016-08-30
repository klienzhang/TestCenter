package com.berserker.testcenterapi.entity;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by klien on 16/8/26.
 */
public class ConfigPropertiesTest {

    @Test
    public static void ConfigTest() throws IOException {
        System.out.println(System.getProperty("user.dir"));
        Properties pps = new Properties();
        InputStream is = ConfigPropertiesTest.class.getResourceAsStream("/properties/config.properties");
        pps.load(is);
        System.out.println(pps.getProperty("env.domain"));
    }
}
