package com.tyc.framework.mybatis.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tyc.boot.common.pojo.PageRequest;
import com.tyc.boot.common.pojo.PageResponse;


/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-17 16:52:08
 */
public class PageUtil {
    public static <T> Page<T> getPage(PageRequest pageReq){
        return new Page<T>(pageReq.getPage(),pageReq.getSize());
    }

    public static <T> PageResponse<T> getPageResp(Page<T> page){
        PageResponse<T> pageResp = new PageResponse<>();
        pageResp.setData(page.getRecords());
        pageResp.setTotal(page.getTotal());
        return pageResp;
    }
}
