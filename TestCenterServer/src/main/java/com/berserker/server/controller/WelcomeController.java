package com.berserker.server.controller;

import com.berserker.server.constants.KeyConstant;
import com.berserker.server.constants.ValueConstant;
import com.berserker.server.model.HtmlModel;
import com.berserker.server.service.WelcomepageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {

    private Logger logger = LogManager.getLogger(WelcomeController.class);

    @Autowired
    private WelcomepageService welcomepageService;

    @ModelAttribute
    public void modelAttribute(Model model){
        HtmlModel m = new HtmlModel();
        model.addAttribute(KeyConstant.KEY_HTML, m.setDomain(ValueConstant.DOMAIN_CONFIG));
    }

    @RequestMapping(value = {"/","/welcome"})
    public String getLoginPage(HttpServletRequest request, Model model){
        logger.info(request.getRemoteAddr() + " is visiting welcome.html");
        model.addAttribute(KeyConstant.KEY_WELCOME_NOTICE, ValueConstant.NOTICE_LIST);
        model.addAttribute(KeyConstant.KEY_PROGRESS, ValueConstant.PROGRESS_LIST);
        return "welcome";
    }
}
