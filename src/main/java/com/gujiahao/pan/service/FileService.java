package com.gujiahao.pan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.gujiahao.pan.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService extends IService<File> {
    //根据用户id查询文件列表
    PageInfo<File> getList(String userId, Integer pageNum, Integer pageSize);

    //文件上传
    boolean upload(Long userId, MultipartFile file);

    //模糊搜索
    PageInfo<File> fuzzySearch(Long userId, String context, Integer pageNum, Integer pageSize);
}
