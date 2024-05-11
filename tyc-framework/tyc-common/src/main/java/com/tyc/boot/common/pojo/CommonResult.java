package com.tyc.boot.common.pojo;

import com.tyc.boot.common.exception.ErrorCode;
import lombok.Data;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Objects;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-10 11:21:51
 */
@Data
public class CommonResult<T> implements Serializable {

    private Integer code;

    private T data;

    private String msg;

    public CommonResult(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public CommonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CommonResult success(){
        return new CommonResult(0,"SUCCESS");
    }

    public static <T>  CommonResult<T> success(T data){
        return new CommonResult(0,data,"SUCCESS");
    }

    public static <T>  CommonResult<T> error(Integer code,String msg){
        return new CommonResult(code,msg);
    }

    public static <T>  CommonResult<T> error(ErrorCode errorCode){
        return new CommonResult(errorCode.getCode(),errorCode.getMsg());
    }

}
