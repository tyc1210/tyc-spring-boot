package com.tyc.module.system.controller.admin.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-14 17:19:52
 */
@Data
public class LoginReqVO {
    @NotEmpty(message = "登录账号不能为空")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    private String passWord;
}
