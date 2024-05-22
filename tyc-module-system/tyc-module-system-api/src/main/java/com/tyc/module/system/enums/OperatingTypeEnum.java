package com.tyc.module.system.enums;


/**
 * 操作类型枚举
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-15 15:46:20
 */
public enum  OperatingTypeEnum {
    LOGIN("登录"),
    LOGOUT("退出"),
    ADD("添加"),
    DELETE("删除"),
    EDIT("修改"),
    QUERY("查询"),
    UPLOAD("上传"),
    SYNC("同步"),
    DISTRIBUTE("下发");

    String description;

    OperatingTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
