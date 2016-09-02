package com.berserker.server.controller.tools;

import com.berserker.server.constants.KeyConstant;
import com.berserker.server.constants.ValueConstant;
import com.berserker.server.model.HtmlModel;
import com.berserker.server.model.PageResponse;
import com.berserker.server.model.tools.ToolsLeaderList;
import com.berserker.server.model.tools.ToolsMobileMgrModel;
import com.berserker.server.service.MobileMgrService;
import com.berserker.server.util.PageResponseUtil;
import com.berserker.testcenterapi.util.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/tools")
public class MobileController {

    @Autowired
    private MobileMgrService mobileMgrService;

    @ModelAttribute
    public void ModelAttribute(Model model){
        HtmlModel m = new HtmlModel();
        model.addAttribute(KeyConstant.KEY_HTML, m.setDomain(ValueConstant.DOMAIN_CONFIG));
    }

    @RequestMapping(value = "/mobile")
    public String getMembersPage(){

        return "/tools/mobile";
    }

    @RequestMapping(value = "/mobile/getLeaderList")
    @ResponseBody
    public PageResponse<ToolsLeaderList> getLeaderList(HttpServletRequest request){
        List<ToolsLeaderList> list = mobileMgrService.getLeaderList();
        return PageResponseUtil.listToPageResponse(list);
    }

    @RequestMapping(value = "/mobile/getMobileList")
    @ResponseBody
    public PageResponse<ToolsMobileMgrModel> getMobileList(HttpServletRequest request){
        ToolsMobileMgrModel model = new ToolsMobileMgrModel();
        List<ToolsMobileMgrModel> list = mobileMgrService.getMobileList(model.getOwner_id());
        return PageResponseUtil.listToPageResponse(list);
    }
}
