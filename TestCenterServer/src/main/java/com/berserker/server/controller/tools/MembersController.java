package com.berserker.server.controller.tools;

import com.berserker.server.constants.KeyConstant;
import com.berserker.server.constants.ValueConstant;
import com.berserker.server.model.HtmlModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tools")
public class MembersController {

    @ModelAttribute
    public void ModelAttribute(Model model){
        HtmlModel m = new HtmlModel();
        model.addAttribute(KeyConstant.KEY_HTML, m.setDomain(ValueConstant.DOMAIN_CONFIG));
    }

    @RequestMapping(value = "/members")
    public String getMembersPage(){

        return "/tools/members";
    }
}
