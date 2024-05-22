package com.tyc.module.system.controller.admin;


import com.tyc.module.system.annotations.OperateLog;
import com.tyc.module.system.controller.admin.vo.AdminOptLogReqVO;
import com.tyc.module.system.controller.admin.vo.LoginReqVO;
import com.tyc.module.system.enums.OperatingModuleEnum;
import com.tyc.module.system.enums.OperatingTypeEnum;
import com.tyc.module.system.service.OperateLogService;
import com.tyc.boot.common.pojo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-16 16:49:33
 */
@RestController
@RequestMapping("gm")
public class AdminController {
    @Autowired
    private OperateLogService operateLogService;


    /**
     * 查看管理员操作日志
     */
    @PostMapping("/operateLog")
    public CommonResult getOptLog(@RequestBody AdminOptLogReqVO adminOptLogReqVO){
        return CommonResult.success(operateLogService.getAdminOperateLogList(adminOptLogReqVO));
    }

    /**
     * 登录
     */
    @PostMapping("/admin/login")
    @OperateLog(operatingModule= OperatingModuleEnum.LOGIN,operatingType = OperatingTypeEnum.LOGIN)
    public CommonResult login(@RequestBody @Valid LoginReqVO loginReqVO){
        return CommonResult.success();
    }

}
