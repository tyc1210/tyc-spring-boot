package com.tyc.module.system.enums;


/**
 * 业务模块名称枚举
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-15 15:44:32
 */
public enum OperatingModuleEnum {
    NULL("无"),
    LOGIN("登录模块");

    String description;

    OperatingModuleEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
