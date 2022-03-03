package com.gujiahao.pan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gujiahao.pan.mapper.FileMapper;
import com.gujiahao.pan.model.File;
import com.gujiahao.pan.service.FileService;
import com.gujiahao.pan.utils.MD5;
import com.gujiahao.pan.utils.PanException;
import com.gujiahao.pan.utils.ResultCodeEnum;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
    //根据用户id查询文件列表
    @Override
    public PageInfo<File> getList(String userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        QueryWrapper<File> wrapper = new QueryWrapper();
        wrapper.eq("user_id", userId);
        final List<File> list = baseMapper.selectList(wrapper);
        PageInfo<File> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    //文件上传
    @Override
    public boolean upload(Long userId, MultipartFile file) {
        //文件不为空
        if (file.isEmpty()) {
            throw new PanException(ResultCodeEnum.FILE_NULL_EXCEPTION);
        }
        final String md5 = MD5.getMD5(file);
        //检查文件是否已上传
        int check = baseMapper.checkDuplicatedFile(userId, md5);
        if(check > 0) {
            throw new PanException(ResultCodeEnum.FILE_ALREADY_EXIST);
        }

        //获取文件名
        final String[] split = file.getOriginalFilename().split("\\.");
        StringBuilder fileName = new StringBuilder(split[0]), fileType = null;
        if(split.length > 1) {
            fileType = new StringBuilder(split[split.length - 1]);
            for(int i = 1; i < split.length-1; i++) {
                fileName.append("." + split[i]);
            }
        }


        //文件上传地址
        StringBuilder filePath = new StringBuilder(System.getProperty("user.dir") + "\\" + "storage" + "\\" + userId);

        //保存文件
        java.io.File dest = new java.io.File(filePath.toString());
        if (!dest.exists()) {
            dest.mkdirs();
        }
        filePath.append("\\" + md5 + "." + split[split.length-1]);
        dest = new java.io.File(filePath.toString());

        //file
        File fileInfo = new File();
        fileInfo.setUserId(userId);
        fileInfo.setFileName(fileName.toString());
        fileInfo.setFileSize(file.getSize());
        fileInfo.setFilePath(filePath.toString());
        fileInfo.setFileMD5(md5);
        fileInfo.setFileType(fileType.toString());
        try {
            file.transferTo(dest);
            final int insert = baseMapper.insert(fileInfo);
            return insert > 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //模糊搜索
    @Override
    public PageInfo<File> fuzzySearch(Long userId, String context, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<File> list = baseMapper.fuzzySearch(userId, context);
        PageInfo<File> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

}
