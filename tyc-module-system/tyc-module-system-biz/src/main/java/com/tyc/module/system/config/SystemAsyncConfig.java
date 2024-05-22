package com.tyc.module.system.config;

import com.tyc.module.system.exception.SystemAsyncExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-16 09:45:25
 */
@Configuration
@EnableAsync
@Slf4j
public class SystemAsyncConfig implements AsyncConfigurer {

    /**
     * 线程池运行任务异常处理器
     */
    @Override
    public AsyncUncaughtExceptionHandler  getAsyncUncaughtExceptionHandler() {
        return new SystemAsyncExceptionHandler();
    }

    /**
     * 处理系统日志线程池
     * @return
     */
    @Bean(name = "operateLogTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(8);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("operateLog-task-Executor-");
        executor.setAwaitTerminationSeconds(30);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAllowCoreThreadTimeOut(true);
        executor.initialize();
        return executor;
    }


}
