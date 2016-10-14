package com.berserker.server.service;

import com.berserker.server.dao.writer.tools.UpdatePasswordMapper;
import com.berserker.server.enums.ResponseEnum;
import com.berserker.server.vo.tools.TestSupportUpdatePasswordEntity;
import com.berserker.testcenterapi.model.ClientResponse;
import com.berserker.testcenterapi.util.encryter.MobileEncryter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestSupportService {
    @Autowired
    private UpdatePasswordMapper mapper;
    private Logger logger = LogManager.getLogger(TestSupportService.class);

    /**
     * 修改密码服务
     * @param mobile
     * @param password
     * @return
     */
    public int updatePassowrd(String mobile, String password){
        try{
            logger.info("mobile:{}, password:{}", mobile, password);
            password = MobileEncryter.encode(password);
            logger.info("password has been encoded:{}", password);
            return mapper.updatePassword(mobile,password);
        }catch (NullPointerException e){
            logger.error(e.getMessage());
            return -1;
        }
    }
}
