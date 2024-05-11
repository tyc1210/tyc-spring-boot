package com.tyc.server.controller;

import cn.hutool.json.JSONUtil;
import com.tyc.boot.common.pojo.CommonResult;
import com.tyc.server.controller.vo.TestVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-11 16:36:45
 */
@RestController
@RequestMapping("test")
public class TestController {

    @PostMapping
    public CommonResult commonResult(@RequestBody @Valid TestVo testVo){
        return CommonResult.success(JSONUtil.toJsonStr(testVo));
    }
}
