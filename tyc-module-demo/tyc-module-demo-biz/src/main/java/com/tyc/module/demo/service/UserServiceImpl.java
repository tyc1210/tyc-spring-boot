package com.tyc.module.demo.service;

import com.tyc.module.demo.controller.vo.UserRespVO;
import com.tyc.module.demo.dal.mapper.UserMapper;
import com.tyc.module.demo.dal.po.UserPO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-11 10:31:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserRespVO getById(Long id) {
        UserPO userPO = userMapper.selectById(id);
        UserRespVO userRespVO = new UserRespVO();
        // todo 使用 map struct 转
        BeanUtils.copyProperties(userPO,userRespVO);
        return userRespVO;
    }
}
