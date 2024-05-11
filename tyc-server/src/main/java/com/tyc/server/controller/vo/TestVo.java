package com.tyc.server.controller.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-11 16:38:05
 */
@Data
public class TestVo {
    @NotNull
    private Long id;
    @NotBlank(message = "用户名不能为空")
    @Size(max = 10, message = "参数名称不能超过 10 个字符")
    private String name;
    @NotBlank
    private String password;
}
