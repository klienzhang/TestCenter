package com.berserker.server.service.impl;

import com.berserker.server.dao.reader.tools.MobileMgrReaderMapper;
import com.berserker.server.dao.writer.tools.MobileMgrWriterMapper;
import com.berserker.testcenterapi.model.PaginatonResponse;
import com.berserker.testcenterapi.model.ClientResponse;
import com.berserker.server.model.tools.MobileDeviceModel;
import com.berserker.server.model.tools.ToolsLeaderList;
import com.berserker.server.model.tools.ToolsMobileMgrModel;
import com.berserker.server.service.MobileMgrService;
import com.berserker.server.util.ResponseUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MobileMgrImpl implements MobileMgrService{

    @Autowired
    private MobileMgrWriterMapper writerMapper;
    @Autowired
    private MobileMgrReaderMapper readerMapper;

    public ClientResponse saveMobile(ToolsMobileMgrModel model) {
        ClientResponse response = new ClientResponse();
        try{
            int result = writerMapper.saveMobile(model);
            response = ResponseUtil.object2SOAResponse(result,result);
        }catch (Exception e){
            response = ResponseUtil.object2SOAResponse(-1,e.getMessage());
        }
        return response;
    }

    public ClientResponse updateMobile(ToolsMobileMgrModel model) {
        ClientResponse response = new ClientResponse();
        try{
            int result = writerMapper.updateMobile(model);
            response = ResponseUtil.object2SOAResponse(result,result);
        }catch (Exception e){
            response = ResponseUtil.object2SOAResponse(-1,e.getMessage());
        }
        return response;
    }

    public ClientResponse deleteMobile(ToolsMobileMgrModel model) {
        ClientResponse response = new ClientResponse();
        try{
            int result = writerMapper.deleteMobile(model.getId(),model.getMobile());
            response = ResponseUtil.object2SOAResponse(result,result);
        }catch (Exception e){
            response = ResponseUtil.object2SOAResponse(-1,e.getMessage());
        }
        return response;
    }

    public PaginatonResponse<MobileDeviceModel> getMobileTypeList(int brand, int type) {
        List<MobileDeviceModel> list = readerMapper.getMobileDeviceList(brand, type);
        return  ResponseUtil.list2PageResponse(list);
    }

    public PaginatonResponse<ToolsLeaderList> getLeaderList() {
        List<ToolsLeaderList> list = readerMapper.getLeaderList();
        return  ResponseUtil.list2PageResponse(list);
    }

    public ClientResponse getMobileInfo(int id){
        ClientResponse response = new ClientResponse();
        try{
            ToolsMobileMgrModel model = readerMapper.getMobileInfo(id);
            response = ResponseUtil.object2SOAResponse(1,model);
        }catch (Exception e){
            response = ResponseUtil.object2SOAResponse(-1,e.getMessage());
        }
        return response;
    }

    public PaginatonResponse<ToolsMobileMgrModel> getMobileList(ToolsMobileMgrModel mobileMgrModel, int currentPage, int pageSize) {
        currentPage = (currentPage < 1) ? 1 : currentPage;
        pageSize = (pageSize < 1) ? 10 : pageSize;
        PageHelper.startPage(currentPage,pageSize);
        List<ToolsMobileMgrModel> list = readerMapper.getMobileList(mobileMgrModel);
        return ResponseUtil.list2PageResponse(list);
    }
}
