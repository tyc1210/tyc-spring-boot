package com.tyc.boot.common.pojo;

import lombok.Data;

import java.util.List;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-16 15:58:08
 */
@Data
public class PageResponse<T> {
    private Long total;
    private List<T> data;
}
