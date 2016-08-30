package com.berserker.testcenterapi.entity;

import com.berserker.server.dao.reader.common.PageComponentReaderMaper;
import com.berserker.server.service.page.PageComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by Administrator on 2016/8/1.
 */
@ContextConfiguration(locations = {"classpath:springmvc-servlet.xml"})
@Component
public class UserTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private PageComponentReaderMaper maper;
    @Autowired
    private PageComponentService service;

    @Test
    public void ChangePasswordTest(){
        //PageHelper.startPage(1,5);
        System.out.println(service.getQuickLinkElements().getList());
        System.out.println(maper.getQuickLinkElements());
        System.out.println("123"+ File.separator);
    }
}
