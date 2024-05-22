package com.tyc.module.system.annotations;


import com.tyc.module.system.enums.OperatingModuleEnum;
import com.tyc.module.system.enums.OperatingTypeEnum;

import java.lang.annotation.*;

/**
 * 操作日志
 * @author tyc
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
public @interface OperateLog {
    /**
     * 操作类型
     */
    OperatingTypeEnum operatingType();

    /**
     * 操作模块
     */
    OperatingModuleEnum operatingModule() default OperatingModuleEnum.NULL;
}
