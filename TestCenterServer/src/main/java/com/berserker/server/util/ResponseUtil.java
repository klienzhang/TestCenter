package com.berserker.server.util;

import com.berserker.testcenterapi.model.PaginatonResponse;
import com.berserker.testcenterapi.model.ClientResponse;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 功能描述： 分页工具
 * @author klien
 * @since 2016-08-02
 */
public class ResponseUtil {

    public static <T> PaginatonResponse<T> list2PageResponse(List<T> list) {
        PaginatonResponse<T> pageResponse = new PaginatonResponse<T>();
        PageInfo<T> info = new PageInfo<T>(list);
        pageResponse.setTotal((int) info.getTotal());
        pageResponse.setRecords(list);
        return pageResponse;
    }

    public static ClientResponse object2SOAResponse(int status, Object data){
        ClientResponse response = new ClientResponse();
        response.setStatus(status);
        if(status > 0){
            response.setData(data);
        }else {
            response.setMsg(data.toString());
        }
        return response;
    }
}
