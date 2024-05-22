package com.tyc.module.system.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-20 16:53:05
 */
@Configuration
@EnableConfigurationProperties({SystemConfigProperties.class})
public class SystemConfig {
}
