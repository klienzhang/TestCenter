package com.berserker.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExceptionPageController {

    @RequestMapping(value = "/error/{errorCode}.html")
    public String siteErrorCollection(@PathVariable String errorCode, ModelAndView modelAndView){
        modelAndView.addObject("errorCode", errorCode.trim());
        return "Exception/ExceptionPage";
    }
}
