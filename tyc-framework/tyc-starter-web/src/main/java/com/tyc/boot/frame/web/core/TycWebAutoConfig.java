package com.tyc.boot.frame.web.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * spring mvc 自动配置
 * 暂未提供额外配置
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-10 10:49:14
 */
@AutoConfiguration
@Slf4j
public class TycWebAutoConfig implements WebMvcConfigurer {
    public TycWebAutoConfig(){
        log.info("[TycWebAutoConfig] ===> init");
    }

}
