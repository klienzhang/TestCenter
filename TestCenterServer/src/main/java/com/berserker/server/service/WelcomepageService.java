package com.berserker.server.service;

import com.berserker.server.model.WelcomeNoticeResponse;
import com.berserker.server.model.WelcomeProjectProgressResponse;
import com.berserker.testcenterapi.model.common.ChildNodeModel;

import java.util.List;

/**
 * Created by klien on 16/7/30.
 */
public interface WelcomepageService {
    List<WelcomeNoticeResponse> getNotice();
    List<WelcomeProjectProgressResponse> getProjectProgress();
    List<ChildNodeModel> getQuickLink();
}
