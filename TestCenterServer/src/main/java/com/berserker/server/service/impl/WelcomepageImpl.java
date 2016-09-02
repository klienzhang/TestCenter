package com.berserker.server.service.impl;

import com.berserker.server.dao.reader.WelcomeMapper;
import com.berserker.server.model.WelcomeNoticeResponse;
import com.berserker.server.model.WelcomeProjectProgressResponse;
import com.berserker.server.service.WelcomepageService;
import com.berserker.testcenterapi.model.common.ChildNodeModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by klien on 16/7/30.
 */
@Service(value = "welcomepage")
public class WelcomepageImpl implements WelcomepageService {

    @Autowired
    private WelcomeMapper maper;

    private Logger logger = LogManager.getLogger(WelcomepageImpl.class);

    /**
     * 功能描述: 获取首页公告列表
     * @return
     */
    public List<WelcomeNoticeResponse> getNotice() {
        try{
            List<WelcomeNoticeResponse> list = maper.getNotices(10);
            list = (list != null)? list : Collections.EMPTY_LIST;
            logger.info("Size is {}", (list.size()));
            return list;
        }catch (Exception e){
            logger.error("Exception: {}", e.getMessage());
            return Collections.EMPTY_LIST;
        }
    }

    /**
     * 功能描述: 获取首页在建工程的工作进度
     * @return
     */
    public List<WelcomeProjectProgressResponse> getProjectProgress() {
        try{
            List<WelcomeProjectProgressResponse> list = maper.getProjectProgress();
            list = (list != null)? list: Collections.EMPTY_LIST;
            logger.info("Size is {}", (list.size()));
            return list;
        }catch (Exception e){
            logger.error("Exception: {}", e.getMessage());
            return Collections.EMPTY_LIST;
        }
    }

    /**
     * 功能描述: 获取首页左侧快捷链接列表
     * @return
     */
    public List<ChildNodeModel> getQuickLink() {
        try{
            List<ChildNodeModel> list = maper.getQuickLink();
            list = (list != null)? list: Collections.EMPTY_LIST;
            logger.info("Size is {}", (list.size()));
            return list;
        }catch (Exception e){
            logger.error("Exception: {}", e.getMessage());
            return Collections.EMPTY_LIST;
        }
    }

}
