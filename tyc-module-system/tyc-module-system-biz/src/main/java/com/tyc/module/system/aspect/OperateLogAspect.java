package com.tyc.module.system.aspect;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tyc.boot.frame.web.util.IpUtil;
import com.tyc.boot.frame.web.util.RequestUtil;
import com.tyc.module.system.annotations.OperateLog;
import com.tyc.module.system.po.OperateLogPO;
import com.tyc.module.system.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 操作日志切面
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-13 17:37:21
 */
@Aspect
@Component
@Slf4j
public class OperateLogAspect {
    @Autowired
    private OperateLogService operateLogService;

    @Pointcut(value = "@annotation(com.tyc.module.system.annotations.OperateLog)")
    public void pointcut() {}

    @After("pointcut()")
    public void insertLog(JoinPoint joinpoint){
        MethodSignature signature = (MethodSignature) joinpoint.getSignature();
        Method method = signature.getMethod();
        boolean hasAnnotation = method.isAnnotationPresent(OperateLog.class);
        if(hasAnnotation){
            OperateLog operateLog = method.getAnnotation(OperateLog.class);
            String module = operateLog.operatingModule().getDescription();
            String type = operateLog.operatingType().getDescription();
            String content = getDetail(method, joinpoint);
            String userName = getUserName(method,joinpoint);
            String ipAddr = IpUtil.getIpAddr(RequestUtil.getRequest());
            OperateLogPO adminOperateLogPO = new OperateLogPO(type,module,userName,ipAddr,content);
            operateLogService.saveLog(adminOperateLogPO);
        }
    }

    private String getUserName(Method method,JoinPoint point){
       return "";
    }



    private String getDetail(Method method, JoinPoint point) {
        Object[] args = point.getArgs();
        Parameter[] params = method.getParameters();
        StringBuilder detailBuff = new StringBuilder();
        if(method.getName().equals("logout")){
            return detailBuff.toString();
        }
        if (params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                if (args[i] instanceof HttpServletRequest ||
                        args[i] instanceof MultipartFile ||
                        args[i] instanceof HttpServletResponse) {
                    continue;
                }
                if (args[i] instanceof String ||
                        args[i] instanceof Integer ||
                        args[i] instanceof Float ||
                        args[i] instanceof Double ||
                        args[i] instanceof BigDecimal ||
                        args[i] instanceof Date ||
                        args[i] instanceof Timestamp) {
                    detailBuff.append(String.valueOf(args[i])).append(",");
                } else {
                    detailBuff.append(JSONUtil.toJsonStr(args[i])).append(",");
                }
            }
            if(detailBuff.length() > 0){
                detailBuff.delete(detailBuff.length() - 1, detailBuff.length());
            }
        }
        return detailBuff.toString();
    }
}
