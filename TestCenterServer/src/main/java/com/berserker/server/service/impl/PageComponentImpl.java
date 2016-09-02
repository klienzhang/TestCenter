package com.berserker.server.service.impl;

import com.berserker.server.dao.reader.common.PageComponentReaderMaper;
import com.berserker.server.model.page.QuickLinkModel;
import com.berserker.server.model.page.SideBarModel;
import com.berserker.server.model.page.TopBarModel;
import com.berserker.server.service.PageComponentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageComponentImpl implements PageComponentService {

    @Autowired
    private PageComponentReaderMaper pageComponentReaderMaper;

    private Logger logger = LogManager.getLogger(PageComponentImpl.class);

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
