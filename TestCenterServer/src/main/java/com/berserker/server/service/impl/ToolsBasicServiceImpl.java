package com.berserker.server.service.impl;

import com.berserker.server.enums.BankEnum;
import com.berserker.server.service.ToolsBasicService;
import com.berserker.server.util.GeneratorUtil;
import com.berserker.server.util.RequestConverter;
import com.berserker.testcenterapi.model.ClientResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ToolsBasicServiceImpl implements ToolsBasicService{

    private int defaultBankId = 10;

    public ClientResponse getBankCardNum(HttpServletRequest request){
        ClientResponse response = new ClientResponse();
        int bankId = RequestConverter.string2Integer(request.getParameter("id"));
        bankId = (bankId == -1)? defaultBankId : bankId;
        response = getBankCardNum(BankEnum.getBankPrefix(bankId),BankEnum.getCardinalNumberLength(bankId));
        return response;
    }

    public ClientResponse getBankCardNum(String prefix, int length){
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

    public ClientResponse getBankList() {
        ClientResponse response = new ClientResponse();
        response.setStatus(1);
        response.setData(BankEnum.getIdAndBankNameMap());
        return response;
    }
}
