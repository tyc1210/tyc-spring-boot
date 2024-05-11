package com.tyc.module.demo.service;

import com.tyc.module.demo.controller.vo.UserRespVO;

public interface UserService {
    UserRespVO getById(Long id);
}
