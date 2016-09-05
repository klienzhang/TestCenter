package com.berserker.server.util;

import com.berserker.server.model.PageResponse;

import java.util.List;

/**
 * 功能描述： 分页工具
 * @author klien
 * @since 2016-08-02
 */
public class PageResponseUtil {

    public static <T> PageResponse<T> listToPageResponse(List<T> list) {
        PageResponse<T> pageResponse = new PageResponse<T>();
        pageResponse.setTotal(list.size());
        pageResponse.setRecords(list);
        return pageResponse;
    }
}
