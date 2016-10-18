package com.berserker.server.dao.reader;

import com.berserker.server.vo.response.BerserkerNoticeResponse;
import com.berserker.server.vo.response.ProjectProgressResponse;
import com.berserker.testcenterapi.model.common.ChildNodeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author klien
 */
public interface WelcomeMapper {
    List<BerserkerNoticeResponse> getNotices(@Param("size") int size);
    List<ChildNodeModel> getQuickLink();
    List<ProjectProgressResponse> getProjectProgress();
}
