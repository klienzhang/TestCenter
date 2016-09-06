//package com.berserker.server.controller.tools;
//
//import com.berserker.server.model.PageResponse;
//import com.berserker.server.model.ResponseModelMap;
//import com.berserker.server.model.tools.AgentDepartmentModel;
//import com.berserker.server.model.tools.AgentInfoModel;
//import com.berserker.server.model.tools.AgentPositionModel;
//import com.berserker.server.service.AgentSearchService;
//import com.berserker.server.util.ResponseUtil;
//import com.berserker.testcenterapi.util.FastJsonUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//@RequestMapping(value = "/tools")
//public class AgentSearchController {
//
//    @Autowired
//    private AgentSearchService searchService;
//
//    @ModelAttribute
//    public void pageInit(Model model){
//
//    }
//
//    @RequestMapping(value = "/addCity")
//    @ResponseBody
//    public ResponseModelMap addCity(HttpServletRequest request, @RequestBody String json){
//        AgentCityModel model = new AgentCityModel();
//        int result = searchService.addCity(model);
//        ResponseModelMap modelMap = new ResponseModelMap();
//        modelMap.setStatus(1);
//        modelMap.setData(result);
//
//        return modelMap;
//    }
//
//    @RequestMapping(value = "/getCityList")
//    @ResponseBody
//    public PageResponse<AgentCityModel> getCity(HttpServletRequest request){
//
//        PageResponse<AgentCityModel> pageResponse = ResponseUtil.listToPageResponse(searchService.getSubCityList());
//        return pageResponse;
//    }
//
//    @RequestMapping(value = "/getDepartmentList", method = RequestMethod.GET)
//    @ResponseBody
//    public PageResponse<AgentDepartmentModel> getDepartment(HttpServletRequest request){
//
//        int isHeadQuarter = Integer.parseInt(request.getParameter("isHeadQuarter"));
//        PageResponse<AgentDepartmentModel> pageResponse =
//                ResponseUtil.listToPageResponse(searchService.getDepartment(isHeadQuarter));
//        return pageResponse;
//    }
//
//    @RequestMapping(value = "/getPositionList")
//    @ResponseBody
//    public PageResponse<AgentPositionModel> getPosition(HttpServletRequest request ,@RequestBody String json){
//        AgentPositionModel model = FastJsonUtil.getSingleBean(json, AgentPositionModel.class);
//        PageResponse<AgentPositionModel> pageResponse =
//                ResponseUtil.listToPageResponse(searchService.getPositionList(model.getDepartment_code()));
//        return pageResponse;
//    }
//
//    @RequestMapping(value = "/getAgentInfoList")
//    @ResponseBody
//    public PageResponse<AgentInfoModel> getAgentInfoList(HttpServletRequest request, @RequestBody String json){
//        AgentInfoModel model = FastJsonUtil.getSingleBean(json, AgentInfoModel.class);
//        PageResponse<AgentInfoModel> pageResponse =
//                ResponseUtil.listToPageResponse(searchService.getAgentInfos(model));
//        return pageResponse;
//    }
//
//    @RequestMapping(value = "/addDepartment")
//    @ResponseBody
//    public ResponseModelMap addDepartment(HttpServletRequest request, @RequestBody String json){
//        AgentDepartmentModel model = new AgentDepartmentModel();
//        int result = searchService.addDepartment(model);
//        ResponseModelMap modelMap = new ResponseModelMap();
//        modelMap.setStatus(1);
//        modelMap.setData(result);
//
//        return modelMap;
//    }
//
//
//
//    @RequestMapping(value = "/addPosition")
//    @ResponseBody
//    public ResponseModelMap addPosition(HttpServletRequest request, @RequestBody String json){
//        AgentPositionModel model = new AgentPositionModel();
//        int result = searchService.addPosition(model);
//        ResponseModelMap modelMap = new ResponseModelMap();
//        modelMap.setStatus(1);
//        modelMap.setData(result);
//
//        return modelMap;
//    }
//
//    @RequestMapping(value = "/addAgentInfo")
//    @ResponseBody
//    public ResponseModelMap addAgentInfo(HttpServletRequest request, @RequestBody String json){
//        AgentInfoModel model = new AgentInfoModel();
//        int result = searchService.addAgentInfo(model);
//        ResponseModelMap modelMap = new ResponseModelMap();
//        modelMap.setStatus(1);
//        modelMap.setData(result);
//
//        return modelMap;
//    }
//}
