package com.tyc.module.demo.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyc.module.demo.dal.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserPO> {
}
