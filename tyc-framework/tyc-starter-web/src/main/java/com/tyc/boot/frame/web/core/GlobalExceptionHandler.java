package com.tyc.boot.frame.web.core;


import com.tyc.boot.common.pojo.CommonResult;
import com.tyc.boot.common.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.tyc.boot.common.exception.GlobalErrorCodeConstants.*;


/**
 * 全局异常拦截处理
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-11 16:15:44
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public CommonResult handleException(Exception e) {
        if (e instanceof BindException) {
            BindException be = (BindException) e;
            String msg = be.getBindingResult().getAllErrors().get(0).getDefaultMessage();
            return CommonResult.error(BAD_REQUEST.getCode(),msg);
        }
        log.warn("[defaultExceptionHandler][msg({})]", ExceptionUtil.getErrorMsg(e));
        return CommonResult.error(INTERNAL_SERVER_ERROR);
    }
}
