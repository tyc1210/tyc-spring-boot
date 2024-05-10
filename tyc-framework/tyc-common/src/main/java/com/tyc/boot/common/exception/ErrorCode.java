package com.tyc.boot.common.exception;

import lombok.Data;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-10 11:29:02
 */
@Data
public class ErrorCode {
    private final Integer code;

    private final String mag;

    public ErrorCode(Integer code, String mag) {
        this.code = code;
        this.mag = mag;
    }
}
