package com.tyc.boot.common.pojo;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-17 15:14:07
 */
public class PageRequest {
    private Integer page;
    private Integer size;
    private Integer start;

    public Integer getStart() {
        return size * (page-1);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
