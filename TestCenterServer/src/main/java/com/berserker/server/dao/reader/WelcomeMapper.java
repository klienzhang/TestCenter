package com.berserker.server.dao.reader;

import com.berserker.server.model.WelcomeNoticeResponse;
import com.berserker.server.model.WelcomeProjectProgressResponse;
import com.berserker.testcenterapi.model.common.ChildNodeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author klien
 */
public interface WelcomeMapper {
    List<WelcomeNoticeResponse> getNotices(@Param("size") int size);
    List<ChildNodeModel> getQuickLink();
    List<WelcomeProjectProgressResponse> getProjectProgress();
}
