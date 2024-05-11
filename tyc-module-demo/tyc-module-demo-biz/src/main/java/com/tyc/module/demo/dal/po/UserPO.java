package com.tyc.module.demo.dal.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-11 10:38:11
 */
@TableName("sys_user")
@Data
public class UserPO {
    @TableId
    private Long id;
    private String name;
    private Integer age;
}
