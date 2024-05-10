package com.tyc.boot.module.demo.controller;

import com.tyc.boot.common.pojo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-10 14:39:13
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping
    public CommonResult hello(){
        return CommonResult.success();
    }
}
