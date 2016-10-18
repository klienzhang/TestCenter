package com.berserker.server.service;

import com.berserker.server.dao.reader.PageComponentReaderMapper;
import com.berserker.server.dao.reader.WelcomeMapper;
import com.berserker.server.vo.component.QuickLinkModel;
import com.berserker.server.vo.component.SideBarModel;
import com.berserker.server.vo.component.TopBarModel;
import com.berserker.server.vo.response.BerserkerNoticeResponse;
import com.berserker.server.vo.response.ProjectProgressResponse;
import com.berserker.testcenterapi.model.common.ChildNodeModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WelcomePageService {

    @Autowired
    private WelcomeMapper maper;
    @Autowired
    private PageComponentReaderMapper pageComponentReaderMaper;

    private Logger logger = LogManager.getLogger(WelcomePageService.class);

    /**
     * 功能描述: 获取首页公告列表
     * @return
     */
    public List<BerserkerNoticeResponse> getNotice() {
        try{
            List<BerserkerNoticeResponse> list = maper.getNotices(10);
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
    public List<ProjectProgressResponse> getProjectProgress() {
        try{
            List<ProjectProgressResponse> list = maper.getProjectProgress();
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

    /**
     * 功能描述: 获取快速导航栏
     * @return
     */
    public QuickLinkModel getQuickLinkElements() {
        QuickLinkModel model = new QuickLinkModel();
        model.setBarName("快速导航栏");
        try{
            model.setList(pageComponentReaderMaper.getQuickLinkElements());
        }catch (Exception e){
            logger.error(e);
        }

        return model;
    }

    /**
     * 功能描述: 获取顶部导航
     * @return
     */
    public TopBarModel getTopBarElements() {
        TopBarModel model = new TopBarModel();
        try{
            model.setUsername(pageComponentReaderMaper.getTopBarElements());
            return model;
        }catch (Exception e){
            logger.error(e);
            return null;
        }
    }

    /**
     * 功能描述: 获取边栏
     * @return
     */
    public SideBarModel getSideBarElements() {

        SideBarModel model = new SideBarModel();
        try{
            model.setName("Main");
            model.setList(pageComponentReaderMaper.getSideBar());
        }catch (Exception e){
            logger.error(e);
            System.out.println("error happen");
        }
        return model;
    }
}
