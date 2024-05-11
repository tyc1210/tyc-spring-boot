package com.tyc.module.demo.controller;

import com.tyc.module.demo.service.UserService;
import com.tyc.boot.common.pojo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-11 10:24:52
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public CommonResult getById(@PathVariable Long id){
        return CommonResult.success(userService.getById(id));
    }
}
