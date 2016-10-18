package com.berserker.server.controller;

import com.berserker.server.constants.KeyConstant;
import com.berserker.server.constants.ValueConstant;
import com.berserker.server.vo.HtmlModel;
import com.berserker.server.service.WelcomePageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author klien
 */
@Controller
public class LandedController {
    @Autowired
    private WelcomePageService componentService;

    private Logger logger = LogManager.getLogger(LandedController.class);

    @ModelAttribute
    public void ModelAttribute(Model model){
        HtmlModel m = new HtmlModel();
        model.addAttribute(KeyConstant.KEY_HTML, m.setDomain(ValueConstant.DOMAIN_CONFIG));
    }

    @RequestMapping(value = "/allservices")
    public String getLandedPage(HttpServletRequest request, Model model){
        logger.info(request.getRemoteAddr() + " is visiting allservices.html");
        model.addAttribute("navbar", componentService.getSideBarElements());
        return "landed";
    }
}
