package com.berserker.server.controller.tools;

import com.berserker.server.service.ToolsBasicService;
import com.berserker.testcenterapi.model.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/tools")
public class GeneratorController {

    @Autowired
    private ToolsBasicService service;

    @RequestMapping(value = "/generator")
    public String getGeneratorPage(){
        return "generator";
    }

    @RequestMapping(value = "/generator/getBankList")
    public ClientResponse getBankList(){
        return service.getBankList();
    }

    @RequestMapping(value = "/generator/getIdCard")
    public ClientResponse getIdCard(HttpServletRequest request){
        return service.getBankCardNum(request);
    }
}
