package com.tyc.boot.common.exception.util;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-10 11:34:08
 */
public class ExceptionUtil {
    /**
     * 默认打印异常堆栈信息行数
     */
    public static final Integer DEFAULT_PRINT_ERROR_LINE = 3;

    public static String getErrorMsg(Throwable throwable,Integer line){
        String msg = "\n"+throwable.toString()+"\n";
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        for (int i = 0; i < stackTrace.length && i < line; i++) {
            msg += "\t"+stackTrace[i].toString() + "\n";
        }
        return msg;
    }

    public static String getErrorMsg(Throwable throwable){
        String msg = "\n"+throwable.toString()+"\n";
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        for (int i = 0; i < stackTrace.length && i < DEFAULT_PRINT_ERROR_LINE; i++) {
            msg += "\t"+stackTrace[i].toString() + "\n";
        }
        return msg;
    }
}
