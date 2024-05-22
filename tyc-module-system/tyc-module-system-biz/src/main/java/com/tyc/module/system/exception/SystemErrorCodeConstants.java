package com.tyc.module.system.exception;


import com.tyc.boot.common.exception.ErrorCode;

/**
 * 错误码枚举
 */
public interface SystemErrorCodeConstants{



    ErrorCode NEED_LOGIN = new ErrorCode(10001, "未登录/登录已过期");


}
