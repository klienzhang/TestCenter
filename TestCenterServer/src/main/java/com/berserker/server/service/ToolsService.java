package com.berserker.server.service;

import com.berserker.server.dao.writer.tools.UpdatePasswordMapper;
import com.berserker.server.enums.BankEnum;
import com.berserker.server.enums.ResponseEnum;
import com.berserker.server.service.tools.PWDUpdaterImpl;
import com.berserker.server.util.GeneratorUtil;
import com.berserker.server.util.RequestConverter;
import com.berserker.testcenterapi.model.ClientResponse;
import com.berserker.testcenterapi.util.FastJsonUtil;
import com.berserker.testcenterapi.util.encryter.MobileEncryter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ToolsService {

    @Autowired
    private PWDUpdaterImpl service;

    private Logger logger = LogManager.getLogger(PWDUpdaterImpl.class);

    /**
     * 测试工具 - 修改密码服务
     * @param request
     * @return
     */
    public ClientResponse changePassword(HttpServletRequest request) {
        ClientResponse response = new ClientResponse();
        String mobile = request.getParameter("mobile");
        String env = request.getParameter("env").toLowerCase().trim();
        if(mobile == null){
            response.setStatus(ResponseEnum.缺少参数.getCode()); //没有传入必要参数
            response.setMsg(ResponseEnum.缺少参数.getMessage());
        }else {
            try{
                logger.info("mobile:{}, env:{}", mobile, env);
                env = (!env.equals("uat"))?"uat":"uat";
                if( env == null || env.equals("sit") || env.equals("uat") || env.equals("dev")){
                    env = "uat";
                }
                int result = service.updatePassowrd(mobile, env);
                if(result == 0){
                    response.setStatus(ResponseEnum.正常.getCode());
                    response.setMsg(mobile + "不存在");
                }else {
                    response.setStatus(ResponseEnum.正常.getCode());
                    response.setMsg(mobile + "的密码修改成功");
                }
            }catch (Exception e){
                response.setStatus(ResponseEnum.未知异常.getCode()); //没有传入必要参数
                response.setMsg(ResponseEnum.未知异常.getMessage());
            }finally {

            }
        }
        logger.info(FastJsonUtil.getObject2Json(response));
        return response;
    }

    /**
     * 测试工具 - 银行卡号生成器
     * @param request
     * @return
     */
    public ClientResponse getBankCardNum(HttpServletRequest request){
        int defaultBankId = 10;
        int bankId = RequestConverter.string2Integer(request.getParameter("id"));
        bankId = (bankId == -1)? defaultBankId : bankId;
        ClientResponse response = getBankCardNum(BankEnum.getBankPrefix(bankId),BankEnum.getCardinalNumberLength(bankId));
        return response;
    }

    /**
     * 测试工具 - 获取所有的银行列表
     * @return
     */
    public ClientResponse getBankList() {
        ClientResponse response = new ClientResponse();
        response.setStatus(1);
        response.setData(BankEnum.getIdAndBankNameMap());
        return response;
    }

    private ClientResponse getBankCardNum(String prefix, int length){
        ClientResponse response = new ClientResponse();
        try{
            response.setData(GeneratorUtil.idCardGenerator(prefix,length));
            response.setStatus(1);
        }catch (NumberFormatException e){
            response.setStatus(-1);
            response.setMsg("请输入数字好么？");
        }catch (Exception e){
            response.setStatus(-1);
            response.setMsg("其他错误");
        }
        return response;
    }
}
