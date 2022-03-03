package com.gujiahao.pan.controller;

import com.alibaba.fastjson.JSONArray;
import com.gujiahao.pan.model.File;
import com.gujiahao.pan.service.FileService;
import com.gujiahao.pan.service.UserService;
import com.gujiahao.pan.utils.AuthContextHolder;
import com.gujiahao.pan.utils.JwtHelper;
import com.gujiahao.pan.utils.Result;
import com.gujiahao.pan.utils.ResultCodeEnum;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "文件管理接口")
@RestController
@RequestMapping("/api/file")
public class FileApiController {
    @Autowired
    private FileService fileService;

    @Autowired
    private UserService userService;

    @GetMapping("getList")
    public Result getFileList(HttpServletRequest request) {
        //token验证
        String token = request.getHeader("token");
        if(token.isEmpty() || AuthContextHolder.isExpired(request)) {
            return Result.fail(ResultCodeEnum.TOKEN_TIME_EXPIRED);
        }

        //从token中获取userid
        final String userId = JwtHelper.getUserId(token);

        //根据id查询文件列表
        List<File> fileList = fileService.getList(userId);

        //封装返回值
        final JSONArray objects = new JSONArray();
        objects.addAll(fileList);
        return Result.ok(objects);
    }
}
