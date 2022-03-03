package com.gujiahao.pan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gujiahao.pan.mapper.FileMapper;
import com.gujiahao.pan.model.File;
import com.gujiahao.pan.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
    //根据用户id查询文件列表
    @Override
    public List<File> getList(String userId) {
        QueryWrapper<File> wrapper = new QueryWrapper();
        wrapper.eq("user_id", userId);
        final List<File> list = baseMapper.selectList(wrapper);

        return list;
    }
}
