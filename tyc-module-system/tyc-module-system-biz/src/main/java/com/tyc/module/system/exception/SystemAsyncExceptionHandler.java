package com.tyc.module.system.exception;

import com.tyc.boot.common.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 异步执行任务异常处理器
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-16 10:19:45
 */
@Slf4j
public class SystemAsyncExceptionHandler extends SimpleAsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        String methodMsg = method.toString();
        log.error("[SystemAsyncExceptionHandler][method:({})][errorMsg:({})]",methodMsg, ExceptionUtil.getErrorMsg(ex));
        new ReentrantLock().lock();
    }
}
