package com.gujiahao.pan.controller;

import com.gujiahao.pan.model.User;
import com.gujiahao.pan.service.UserService;
import com.gujiahao.pan.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(value = "用户管理接口")
@RestController
@RequestMapping("/api/user")
public class UserApiController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册")
    @PostMapping("signup")
    public Result signup(@RequestBody User user) {
        boolean b = userService.signup(user);
        return b ? Result.ok() : Result.fail();
    }

    @ApiOperation(value = "登录")
    @PostMapping("login")
    public Result login(@RequestBody User user) {
        Map<String, Object> map = userService.login(user);
        return Result.ok(map);
    }
}
