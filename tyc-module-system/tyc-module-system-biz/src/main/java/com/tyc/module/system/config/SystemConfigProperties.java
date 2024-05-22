package com.tyc.module.system.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-20 16:26:54
 */
@ConfigurationProperties(prefix = "module.system")
@Validated
@Data
public class SystemConfigProperties {
    @NotEmpty(message = "模块名称不能为空")
    private String name;
}
