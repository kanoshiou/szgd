package com.gujiahao.pan.utils;

import org.joda.time.DateTime;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//获取当前用户信息工具类
public class AuthContextHolder {
    // 获取当前用户id
    public static String  getUserId(HttpServletRequest request) {
        //从header获取token
        final String token = request.getHeader("token");

        //jwt从token获取userid
        final String userId = JwtHelper.getUserId(token);

        return userId;
    }

    //获取当前用户昵称
    public static String getUserName(HttpServletRequest request) {
        //从header获取token
        final String token = request.getHeader("token");

        //jwt从token获取username
        final String userName = JwtHelper.getUserName(token);

        return userName;
    }

    /**
     * 检查token是否过期
     * @param request
     * @return true：已过期 false：未过期
     */
    public static boolean isExpired(HttpServletRequest request) {
        //从header获取token
        final String token = request.getHeader("token");

        //jwt从token获取过期时间
        final Date expiration = JwtHelper.getExpiration(token);

        DateTime exp = new DateTime(expiration);
        return exp.isBeforeNow() ? true : false;
    }
}
