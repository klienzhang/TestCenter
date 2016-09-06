package com.berserker.server.service.impl;

import com.berserker.server.dao.reader.tools.MobileMgrReaderMapper;
import com.berserker.server.dao.writer.tools.MobileMgrWriterMapper;
import com.berserker.server.model.PageResponse;
import com.berserker.server.model.SOAResponse;
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

    public SOAResponse saveMobile(ToolsMobileMgrModel model) {
        SOAResponse response = new SOAResponse();
        try{
            int result = writerMapper.saveMobile(model);
            response = ResponseUtil.object2SOAResponse(result,result);
        }catch (Exception e){
            response = ResponseUtil.object2SOAResponse(-1,e.getMessage());
        }
        return response;
    }

    public SOAResponse updateMobile(ToolsMobileMgrModel model) {
        SOAResponse response = new SOAResponse();
        try{
            int result = writerMapper.updateMobile(model);
            response = ResponseUtil.object2SOAResponse(result,result);
        }catch (Exception e){
            response = ResponseUtil.object2SOAResponse(-1,e.getMessage());
        }
        return response;
    }

    public SOAResponse deleteMobile(ToolsMobileMgrModel model) {
        SOAResponse response = new SOAResponse();
        try{
            int result = writerMapper.deleteMobile(model.getId(),model.getMobile());
            response = ResponseUtil.object2SOAResponse(result,result);
        }catch (Exception e){
            response = ResponseUtil.object2SOAResponse(-1,e.getMessage());
        }
        return response;
    }

    public PageResponse<MobileDeviceModel> getMobileTypeList(int brand, int type) {
        List<MobileDeviceModel> list = readerMapper.getMobileDeviceList(brand, type);
        return  ResponseUtil.list2PageResponse(list);
    }

    public PageResponse<ToolsLeaderList> getLeaderList() {
        List<ToolsLeaderList> list = readerMapper.getLeaderList();
        return  ResponseUtil.list2PageResponse(list);
    }

    public ToolsMobileMgrModel getMobileInfo(int id){
        return readerMapper.getMobileInfo(id);
    }

    public PageResponse<ToolsMobileMgrModel> getMobileList(ToolsMobileMgrModel mobileMgrModel, int currentPage, int pageSize) {
        currentPage = (currentPage < 1) ? 1 : currentPage;
        pageSize = (pageSize < 1) ? 10 : pageSize;
        PageHelper.startPage(currentPage,pageSize);
        List<ToolsMobileMgrModel> list = readerMapper.getMobileList(mobileMgrModel);
        return ResponseUtil.list2PageResponse(list);
    }
}
