package com.berserker.server.controller.other;

import com.berserker.server.model.tools.AgentCityModel;
import com.berserker.testcenterapi.model.ClientResponse;
import com.berserker.testcenterapi.util.FastJsonUtil;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/mock")
public class MockController {

    //?id=****&name=****
    @ResponseBody
    @RequestMapping(value = "/getTest", method = {RequestMethod.GET})
    public ClientResponse getMockTest(HttpServletRequest request){
        System.out.println(request.getRemoteHost());
        ClientResponse response = new ClientResponse();
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            AgentCityModel model = new AgentCityModel();
            model.setCity_code(id);
            model.setCity_name(name);
            response.setStatus(1);
            response.setData(model);
        }catch (Exception e){
            response.setStatus(-9999);
            response.setMsg(e.getMessage());
        }

        return response;
    }

    @ResponseBody
    @RequestMapping(value = "/postTest", method = {RequestMethod.POST})
    public ClientResponse getMockTestPost(HttpServletRequest request, @RequestBody String json){
        ClientResponse response = new ClientResponse();
        try{
            AgentCityModel model = FastJsonUtil.getSingleBean(json, AgentCityModel.class);
            response.setStatus(1);
            response.setData(model);
        }catch (Exception e){
            response.setStatus(-9999);
            response.setMsg(e.getMessage());
        }
        return response;
    }
}
