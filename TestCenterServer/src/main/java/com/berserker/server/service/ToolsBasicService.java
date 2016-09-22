package com.berserker.server.service;

import com.berserker.testcenterapi.model.ClientResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface ToolsBasicService {
    ClientResponse getBankCardNum(HttpServletRequest request);
    ClientResponse getBankList();
    ClientResponse getBankCardNum(String prefix, int length);
}
