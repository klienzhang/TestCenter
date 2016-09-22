package com.berserker.server.controller.tools;

import com.alibaba.fastjson.JSON;
import com.berserker.server.constants.KeyConstant;
import com.berserker.server.constants.ValueConstant;
import com.berserker.server.model.HtmlModel;
import com.berserker.server.service.PageComponentService;
import com.berserker.server.service.PasswordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "tools")
public class ChangePWDController {

    @Autowired
    private PasswordService service;
    @Autowired
    private PageComponentService pageComponentService;

    private Logger logger = LogManager.getLogger(ChangePWDController.class);

    @ModelAttribute
    public void ModelAttribute(Model model){
        HtmlModel m = new HtmlModel();
        model.addAttribute(KeyConstant.KEY_HTML, m.setDomain(ValueConstant.DOMAIN_CONFIG));
    }

    @RequestMapping(value = "/changepassword")
    public String changePassword(Model model){
        return "/tools/password";
    }

    public ModelAndView changePass(){
        ModelAndView modelAndView = new ModelAndView("/tools/password");
        return modelAndView;
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> updatePassword(@RequestBody String order, HttpServletRequest request){
        String returnContent = new String();
        try {
            Map<String ,String> map = (Map<String, String>) JSON.parse(order);
            returnContent = service.changePassword(map.get("mobile"), "Aaa123" ,map.get("env"));
        } catch (Exception e) {
            returnContent = e.getMessage();
        }

        Map<String, String> result = new HashMap<String, String>();
        result.put("enums", returnContent);
        return result;
    }
}
