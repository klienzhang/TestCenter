package com.berserker.server.util;

import com.berserker.server.model.PageResponse;
import com.berserker.server.model.SOAResponse;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 功能描述： 分页工具
 * @author klien
 * @since 2016-08-02
 */
public class ResponseUtil {

    public static <T> PageResponse<T> list2PageResponse(List<T> list) {
        PageResponse<T> pageResponse = new PageResponse<T>();
        PageInfo<T> info = new PageInfo<T>(list);
        pageResponse.setTotal((int) info.getTotal());
        pageResponse.setRecords(list);
        return pageResponse;
    }

    public static SOAResponse object2SOAResponse(int status, Object data){
        SOAResponse response = new SOAResponse();
        response.setStatus(status);
        if(status > 0){
            response.setData(data);
        }else {
            response.setMsg(data.toString());
        }
        return response;
    }
}
