package com.berserker.server.service;

import com.berserker.server.dao.writer.tools.UpdatePasswordMapper;
import com.berserker.server.enums.ResponseEnum;
import com.berserker.testcenterapi.model.ClientResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class PasswordUpdateService {

    @Autowired
    private TestSupportService service;

    private Logger logger = LogManager.getLogger(PasswordUpdateService.class);

    public ClientResponse changePassword(HttpServletRequest request) {
        ClientResponse response = new ClientResponse();
        String mobile = request.getParameter("mobile");
        String env = request.getParameter("env").toLowerCase().trim();
        if(mobile == null){
            response.setStatus(ResponseEnum.缺少参数.getCode()); //没有传入必要参数
            response.setMsg(ResponseEnum.缺少参数.getMessage());
            return response;
        }else {
            try{
                logger.info("mobile:{}, env:{}", mobile, env);
                env = (env.equals("sit"))?"sit":"uat";
            }catch (Exception e){
                response.setStatus(ResponseEnum.未知异常.getCode()); //没有传入必要参数
                response.setMsg(ResponseEnum.未知异常.getMessage());
            }finally {

            }
            return response;
        }
    }
}
