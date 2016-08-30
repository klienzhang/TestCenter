package com.berserker.server.service.tools;

import com.berserker.server.dao.reader.ChangePasswordMaper;
import com.berserker.server.entity.tools.ChangePasswordEntity;
import com.berserker.server.util.DynamicDataSourceUtil;
import com.berserker.testcenterapi.util.DateUtil;
import com.berserker.testcenterapi.util.Md5Util;
import com.berserker.testcenterapi.util.encryter.MobileEncryter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author klien
 */
@Component
public class PasswordImpl implements PasswordService {

    @Autowired
    private ChangePasswordMaper maper;

    private Logger logger = LogManager.getLogger(PasswordImpl.class);

    /**
     * 功能描述： 修改密码服务
     * @param mobile
     * @param password
     * @return
     */
    public String changePassword(String mobile, String password, String TargetDataSource) {
        String logMessage = new String();
        if(mobile == null || password == null){
            logMessage = "传入的参数有误，请检查数据";
            logger.error(logMessage);
        }else {
            try{
                logger.info("mobile:{},password:{},Env:{}", mobile,password,TargetDataSource);
                ChangePasswordEntity entity = new ChangePasswordEntity(MobileEncryter.encode(mobile.trim()),
                        Md5Util.GetMD5Context(password), DateUtil.getDate(0,DateUtil.DATETIME_FORMAT));
                DynamicDataSourceUtil.setTargetDataSource(TargetDataSource);
                int result = maper.updatePassword(entity);
                if (result > 0){
                    logMessage = mobile + "的密码更新成功";
                }else {
                    logMessage = "没有查询到该电话号码:" + mobile;
                }
                logger.info(logMessage);
            }catch (Exception e){
                logMessage = "发生异常，请联系Klien";
                logger.error(logMessage);
            }finally {
                DynamicDataSourceUtil.setTargetDataSource("dev");
            }
        }
        return logMessage;
    }
}
