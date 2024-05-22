package com.tyc.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyc.module.system.controller.admin.vo.AdminOptLogReqVO;
import com.tyc.module.system.po.OperateLogPO;
import com.tyc.boot.common.pojo.PageResponse;

/**
 * @author admin
 */
public interface OperateLogService extends IService<OperateLogPO> {

    PageResponse<OperateLogPO> getAdminOperateLogList(AdminOptLogReqVO adminOptLogReqVO);

    void saveLog(OperateLogPO adminOperateLogPO);
}
