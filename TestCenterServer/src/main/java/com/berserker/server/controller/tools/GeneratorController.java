package com.berserker.server.controller.tools;

import com.berserker.server.service.ToolsService;
import com.berserker.testcenterapi.model.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/tools")
public class GeneratorController {

    @Autowired
    private ToolsService service;

    @RequestMapping(value = "/generator")
    public String getGeneratorPage(){
        return "generator";
    }

    @ResponseBody
    @RequestMapping(value = "/generator/getBankList")
    public ClientResponse getBankList(){
        return service.getBankList();
    }

    @ResponseBody
    @RequestMapping(value = "/generator/getIdCard")
    public ClientResponse getIdCard(HttpServletRequest request){
        return service.getBankCardNum(request);
    }
}
