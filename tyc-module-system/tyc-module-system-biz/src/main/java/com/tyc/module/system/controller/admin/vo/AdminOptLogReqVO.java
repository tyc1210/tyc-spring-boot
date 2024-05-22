package com.tyc.module.system.controller.admin.vo;

import com.tyc.boot.common.pojo.PageRequest;
import lombok.Data;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-16 16:52:05
 */
@Data
public class AdminOptLogReqVO extends PageRequest {
    private String operatorName;
    private String optIp;
    private String optType;
    private String optModule;
}
