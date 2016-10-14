package com.berserker.server.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserRegisterController {

    public ModelAndView renderRegisterPage(){
        ModelAndView mav = new ModelAndView();

        return mav;
    }

    @RequestMapping(value = "/source")
    public ModelAndView redirectToLogin(RedirectAttributes attributes){
        System.out.println("This is source");
        attributes.addAttribute("name","klien");
        return new ModelAndView("redirect:/target.do");
    }

    @RequestMapping(value = "/target")
    public ModelAndView redirectTarget(HttpServletRequest request, RedirectAttributes attributes){
        System.out.println(request.getParameter("name"));
        ModelAndView mav = new ModelAndView();
        mav.setViewName("forward:/welcome.html");
        return mav;
    }
}
