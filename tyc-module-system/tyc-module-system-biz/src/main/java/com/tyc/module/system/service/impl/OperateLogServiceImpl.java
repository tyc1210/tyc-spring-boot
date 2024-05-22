package com.tyc.module.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyc.module.system.controller.admin.vo.AdminOptLogReqVO;
import com.tyc.module.system.mapper.OperateLogMapper;
import com.tyc.module.system.po.OperateLogPO;
import com.tyc.module.system.service.OperateLogService;
import com.tyc.boot.common.pojo.PageResponse;
import com.tyc.framework.mybatis.util.LambdaQueryWrapperX;
import com.tyc.framework.mybatis.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLogPO> implements OperateLogService {


    @Async("operateLogTaskExecutor")
    @Override
    public void saveLog(OperateLogPO adminOperateLogPO){
        save(adminOperateLogPO);
    };

    @Override
    public PageResponse<OperateLogPO> getAdminOperateLogList(AdminOptLogReqVO operateLogPO) {
        Page<OperateLogPO> page = PageUtil.getPage(operateLogPO);
        LambdaQueryWrapperX<OperateLogPO> queryWrapper = new LambdaQueryWrapperX<>();
        queryWrapper
                .eqIfPresent(OperateLogPO::getOperatorName,operateLogPO.getOperatorName())
                .eqIfPresent(OperateLogPO::getOptModule,operateLogPO.getOptModule())
                .eqIfPresent(OperateLogPO::getOptType,operateLogPO.getOptType())
                .eqIfPresent(OperateLogPO::getOptIp,operateLogPO.getOptIp())
                .orderByDesc(OperateLogPO::getOptTime);
        page(page,queryWrapper);
        return PageUtil.getPageResp(page);
    }
}
