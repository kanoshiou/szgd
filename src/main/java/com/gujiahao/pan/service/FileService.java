package com.gujiahao.pan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gujiahao.pan.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService extends IService<File> {
    //根据用户id查询文件列表
    List<File> getList(String userId);

    //文件上传
    boolean upload(Long userId, MultipartFile file);
}
