package com.gujiahao.pan.controller;

import com.github.pagehelper.PageInfo;
import com.gujiahao.pan.model.File;
import com.gujiahao.pan.model.User;
import com.gujiahao.pan.service.FileService;
import com.gujiahao.pan.service.UserService;
import com.gujiahao.pan.utils.AuthContextHolder;
import com.gujiahao.pan.utils.JwtHelper;
import com.gujiahao.pan.utils.Result;
import com.gujiahao.pan.utils.ResultCodeEnum;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("getList/{pageNum}")
    public Result getFileList(@PathVariable Integer pageNum, HttpServletRequest request) {
        //token验证
        String token = request.getHeader("token");
        if(token.isEmpty() || AuthContextHolder.isExpired(request)) {
            return Result.fail(ResultCodeEnum.TOKEN_TIME_EXPIRED);
        }

        //从token中获取userid
        final String userId = JwtHelper.getUserId(token);

        //根据id查询文件列表
        PageInfo<File> fileList = fileService.getList(userId,pageNum,10);

        return Result.ok(fileList);
    }

    @PostMapping("uploadFile")
    public Result upload(MultipartFile file,
                         HttpServletRequest request) {
        //token验证
        String token = request.getHeader("token");
        if(token.isEmpty() || AuthContextHolder.isExpired(request)) {
            return Result.fail(ResultCodeEnum.TOKEN_TIME_EXPIRED);
        }

        //从token中获取userid
        final Long userId = Long.parseLong(JwtHelper.getUserId(token));

        final long size = file.getSize();

        //用户剩余空间检查
        User userInfo = userService.checkSpace(userId, size);
        if(null == userInfo) {
            return Result.fail(ResultCodeEnum.OUT_OF_SPACE_ERROR);
        }

        //文件上传
        boolean uploaded =  fileService.upload(userId, file);
        if (!uploaded) {
            return Result.fail(ResultCodeEnum.UPLOAD_ERROR);
        }

        return Result.ok(userInfo);
    }

    @GetMapping("fuzzySearch/{context}/{pageNum}")
    public Result fuzzySearch(@PathVariable String context,@PathVariable Integer pageNum, HttpServletRequest request) {
        //token验证
        String token = request.getHeader("token");
        if(token.isEmpty() || AuthContextHolder.isExpired(request)) {
            return Result.fail(ResultCodeEnum.TOKEN_TIME_EXPIRED);
        }

        //从token中获取userid
        final Long userId = Long.parseLong(JwtHelper.getUserId(token));

        //模糊搜索
        PageInfo<File> fileList = fileService.fuzzySearch(userId, context, pageNum, 10);
        return  Result.ok(fileList);
    }



}
