package com.berserker.server.service.impl;

import com.berserker.server.dao.reader.tools.MobileMgrReaderMapper;
import com.berserker.server.dao.writer.tools.MobileMgrWriterMapper;
import com.berserker.server.model.PageResponse;
import com.berserker.server.model.tools.ToolsLeaderList;
import com.berserker.server.model.tools.ToolsMobileMgrModel;
import com.berserker.server.service.MobileMgrService;
import com.berserker.server.util.PageResponseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MobileMgrImpl implements MobileMgrService{

    @Autowired
    private MobileMgrWriterMapper writerMapper;
    @Autowired
    private MobileMgrReaderMapper readerMapper;

    public int saveMobile(ToolsMobileMgrModel model) {
        return writerMapper.saveMobile(model);
    }

    public int updateMobile(ToolsMobileMgrModel model) {
        return writerMapper.updateMobile(model);
    }

    public int deleteMobile(ToolsMobileMgrModel model) {
        return writerMapper.deleteMobile(model);
    }

    public PageResponse<ToolsMobileMgrModel> getMobileList(int leader_id, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<ToolsMobileMgrModel> list = readerMapper.getMobileList(leader_id);
        return PageResponseUtil.listToPageResponse(list);
    }

    public List<ToolsLeaderList> getLeaderList() {
        return readerMapper.getLeaderList();
    }

    public ToolsMobileMgrModel getMobileInfo(int id){
        return readerMapper.getMobileInfo(id);
    }
}
