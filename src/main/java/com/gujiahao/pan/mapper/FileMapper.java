package com.gujiahao.pan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gujiahao.pan.model.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileMapper extends BaseMapper<File> {

    //查询同一用户重复文件
    @Select("SELECT count(*) FROM t_file WHERE file_MD5 = #{md5} AND user_id = #{userId}")
    int checkDuplicatedFile(Long userId, String md5);
}
