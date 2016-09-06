package com.berserker.server.controller.tools;

import com.berserker.server.constants.KeyConstant;
import com.berserker.server.constants.ValueConstant;
import com.berserker.server.model.HtmlModel;
import com.berserker.server.model.PageResponse;
import com.berserker.server.model.SOAResponse;
import com.berserker.server.model.tools.MobileDeviceModel;
import com.berserker.server.model.tools.ToolsLeaderList;
import com.berserker.server.model.tools.ToolsMobileMgrModel;
import com.berserker.server.service.MobileMgrService;
import com.berserker.server.util.RequestConverter;
import com.berserker.server.util.ResponseUtil;
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

        return "/tools/mobileManager";
    }

    @RequestMapping(value = "/mobile/getLeaderList")
    @ResponseBody
    public PageResponse<ToolsLeaderList> getLeaderList(HttpServletRequest request){
        return mobileMgrService.getLeaderList();
    }

    @RequestMapping(value = "/mobile/getMobileTypeList")
    @ResponseBody
    public PageResponse<MobileDeviceModel> getMobileTypeList(HttpServletRequest request){
        int brand = RequestConverter.string2Integer(request.getParameter("brand"));
        int type = RequestConverter.string2Integer(request.getParameter("type"));
        logger.info("getMobileTypeList - brand:{}, type:{}", brand, type);
        return mobileMgrService.getMobileTypeList(brand,type);
    }

    @RequestMapping(value = "/mobile/getMobileList")
    @ResponseBody
    public PageResponse<ToolsMobileMgrModel> getMobileList(HttpServletRequest request){
        ToolsMobileMgrModel model = new ToolsMobileMgrModel();
        int owner_id = Integer.valueOf(request.getParameter("id"));
        int brandId = Integer.valueOf(request.getParameter("brandId"));
        int typeId = Integer.valueOf(request.getParameter("typeId"));
        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int pageSize = Integer.valueOf(request.getParameter("pageSize"));
        logger.info("getMobileList. id:{}, brand:{}, type:{},currentPage:{}, pageSize:{}",
                owner_id, brandId, typeId, currentPage, pageSize);
        model.setOwner_id(owner_id);
        model.setBrandId(brandId);
        model.setTypeId(typeId);
        PageResponse<ToolsMobileMgrModel> response =  mobileMgrService.getMobileList(model,currentPage,pageSize);
        logger.info("Total is {}, list is {}", response.getTotal(), response.getRecords());
        return response;
    }

    @RequestMapping(value = "/mobile/getMobileInfo")
    @ResponseBody
    public ToolsMobileMgrModel getMobileInfo(HttpServletRequest request){
        int id = Integer.valueOf(request.getParameter("id"));
        logger.info("getMobileInfo. id:{}",id);
        ToolsMobileMgrModel model = mobileMgrService.getMobileInfo(id);
        return model;
    }

    @RequestMapping(value = "/mobile/updateMobileInfo")
    @ResponseBody
    public SOAResponse updateMobileInfo(HttpServletRequest request, @RequestBody String order){
        ToolsMobileMgrModel mobileMgrModel = FastJsonUtil.getSingleBean(order,ToolsMobileMgrModel.class);
        return mobileMgrService.updateMobile(mobileMgrModel);
    }
}
