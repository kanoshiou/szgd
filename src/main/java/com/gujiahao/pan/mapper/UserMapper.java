package com.gujiahao.pan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gujiahao.pan.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
