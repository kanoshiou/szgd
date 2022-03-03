package com.gujiahao.pan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gujiahao.pan.model.User;

import java.util.Map;

public interface UserService extends IService<User> {
    //登录
    Map<String, Object> login(User user);

    //注册
    boolean signup(User user);

    //用户剩余空间检查
    boolean checkSpace(Long userId, long size);
}
