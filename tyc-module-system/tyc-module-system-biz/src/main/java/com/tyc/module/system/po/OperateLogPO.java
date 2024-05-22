package com.tyc.module.system.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

import static com.tyc.boot.common.util.DateUtil.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;
import static com.tyc.boot.common.util.DateUtil.TIME_ZONE_DEFAULT;

/**
 * 管理员操作日志
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-14 17:56:35
 */
@Data
@TableName("adminOperateLog")
public class OperateLogPO {
    @TableId
    private Long id;
    private String optType;
    private String optModule;
    private String operatorName;
    private String optIp;
    private String optContent;
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, timezone = TIME_ZONE_DEFAULT)
    private LocalDateTime optTime;

    public OperateLogPO(String optType, String optModule, String operatorName, String optIp, String optContent) {
        this.optType = optType;
        this.optModule = optModule;
        this.operatorName = operatorName;
        this.optIp = optIp;
        this.optContent = optContent;
        this.optTime = LocalDateTime.now();
    }
}
