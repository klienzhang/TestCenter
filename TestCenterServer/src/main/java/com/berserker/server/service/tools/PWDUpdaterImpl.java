package com.berserker.server.service.tools;

import com.berserker.server.dao.writer.tools.UpdatePasswordMapper;
import com.berserker.server.service.ToolsService;
import com.berserker.testcenterapi.util.encryter.MobileEncryter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PWDUpdaterImpl {

    @Autowired
    private UpdatePasswordMapper mapper;

    private Logger logger = LogManager.getLogger(ToolsService.class);

    public int updatePassowrd(String mobile, String password) throws Exception{
        password = MobileEncryter.encode(password);
        logger.debug("password has been encoded to :{}", password);
        return mapper.updatePassword(mobile,password);
    }
}
