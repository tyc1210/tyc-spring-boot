package com.tyc.boot.common.exception;

import lombok.Data;

/**
 * 通用异常
 *
 * @author jiufang
 * @version 1.0
 * @date 2024-05-10 11:30:35
 */
@Data
public class CommonException extends RuntimeException{
    private Integer code;
    private String msg;

    public CommonException(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
