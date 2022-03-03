package com.gujiahao.pan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gujiahao.pan.model.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileMapper extends BaseMapper<File> {

    //查询同一用户重复文件
    @Select("SELECT count(*) FROM t_file WHERE file_MD5 = #{md5} AND user_id = #{userId}")
    int checkDuplicatedFile(Long userId, String md5);

    //模糊查询
    @Select("SELECT file_id, user_id, file_name, file_type, file_size, file_path, file_MD5 FROM `t_file` WHERE user_id = #{userId} AND file_name LIKE CONCAT('%',#{context},'%')")
    List<File> fuzzySearch(Long userId, String context);
}
