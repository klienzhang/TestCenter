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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private Logger logger = LogManager.getLogger(MobileController.class);

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
        logger.info("{} is visiting getMobileList. id:{}, currentPage:{}, pageSize:{}", request.getRemoteHost(),
                request.getParameter("id"),request.getParameter("currentPage"), request.getParameter("pageSize"));
        PageResponse<ToolsMobileMgrModel> response =  mobileMgrService.getMobileList(Integer.valueOf(request.getParameter("id")),Integer.valueOf(request.getParameter("currentPage")),
                Integer.valueOf(request.getParameter("pageSize")));
        logger.info("Total is {}, list is {}", response.getTotal(), response.getRecords());
        return response;
    }

    @RequestMapping(value = "/mobile/getMobileInfo")
    @ResponseBody
    public ToolsMobileMgrModel getMobileInfo(HttpServletRequest request){
        logger.info("{} is visiting getMobileInfo. id:{}", request.getRemoteHost(), Integer.valueOf(request.getParameter("id")));
        ToolsMobileMgrModel model = mobileMgrService.getMobileInfo(Integer.valueOf(request.getParameter("id")));
        return model;
    }

    @RequestMapping(value = "/mobile/updateMobileInfo")
    @ResponseBody
    public String updateMobileInfo(HttpServletRequest request, @RequestBody String order){
        ToolsMobileMgrModel mobileMgrModel = FastJsonUtil.getSingleBean(order,ToolsMobileMgrModel.class);
        System.out.println(mobileMgrModel.getUser());
        int result = mobileMgrService.updateMobile(mobileMgrModel);
        if(result > 0)
            return "success";
        else
            return "fail";
    }
}
