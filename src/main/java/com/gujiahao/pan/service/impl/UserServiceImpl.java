package com.gujiahao.pan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gujiahao.pan.mapper.UserMapper;
import com.gujiahao.pan.model.User;
import com.gujiahao.pan.service.UserService;
import com.gujiahao.pan.utils.EncryptorUtils;
import com.gujiahao.pan.utils.JwtHelper;
import com.gujiahao.pan.utils.PanException;
import com.gujiahao.pan.utils.ResultCodeEnum;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    //登录
    @Override
    public Map<String, Object> login(User user) {
        //根据用户名查询数据库
        QueryWrapper wrapper = new QueryWrapper<>();
        final String userName = user.getUserName();
        wrapper.eq("user_name", userName);
        final User userInfo = baseMapper.selectOne(wrapper);

        //不存在用户
        if(null == userInfo) {
            throw new PanException(ResultCodeEnum.DATA_ERROR);
        }

        //验证密码
        final EncryptorUtils encryptorUtils = new EncryptorUtils();
        final boolean verify = encryptorUtils.verify(user, userInfo);
        if(!verify) {
            throw new PanException(ResultCodeEnum.PASSWORD_ERROR);
        }
        //根据id和用户名生成token
        String token = JwtHelper.createToken(String.valueOf(userInfo.getUserId()), userInfo.getUserName());

        //构造返回值
        Map<String, Object> map = new HashMap<>();
        map.put("userId",userInfo.getUserId());
        map.put("userName",userInfo.getUserName());
        map.put("token",token);
        map.put("totalSpace",userInfo.getTotalSpace());
        map.put("usedSpace",userInfo.getUsedSpace());
        return map;
    }

    //注册
    @Override
    public boolean signup(User user) {
        //检测数据库中是否有重复用户名
        if(this.checkDuplicatedUsername(user.getUserName())) {
            throw new PanException(ResultCodeEnum.DUPLICATED_NAME_ERROR);
        }

        //密码加密
        final EncryptorUtils encryptorUtils = new EncryptorUtils();
        final String encryptedPassword = encryptorUtils.encrypt(user.getUserPassword());

        //user
        User userInfo = new User();
        userInfo.setUserName(user.getUserName());
        userInfo.setUserPassword(encryptedPassword);
        userInfo.setTotalSpace(10485760L);
        userInfo.setUsedSpace(0L);

        //上传数据库
        final int insert = baseMapper.insert(user);

        return insert > 0;
    }

    /**
     *检查重复用户名
     * @param userName
     * @return true：存在重复 false：不存在重复
     */
    private boolean checkDuplicatedUsername(String userName) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        final Integer count = baseMapper.selectCount(wrapper);
        return count != 0;
    }
}
