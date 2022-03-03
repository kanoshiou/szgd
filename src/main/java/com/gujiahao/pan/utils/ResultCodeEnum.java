package com.gujiahao.pan.utils;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 *
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    PARAM_ERROR( 202, "参数不正确"),
    SERVICE_ERROR(203, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    DATA_UPDATE_ERROR(205, "数据版本异常"),
    ORDER_TYPE_ERROR(206, "排序方法错误"),

    TOKEN_ERROR(209, "token异常"),
    TOKEN_TIME_EXPIRED(208, "token过期"),
    CODE_TIME_EXPIRED(209, "验证码过期"),
    CODE_ERROR(210, "验证码错误"),
    PASSWORD_ERROR(211, "密码错误"),
    REGISTER_USERNAME_ERROR(212, "用戶名已被使用"),
    REGISTER_MOBILE_ERROR(213, "手机号已被使用"),
    USER_STATUS_ERROR(214, "用户状态异常"),



    DUPLICATED_NAME_ERROR(405,"存在重复用户名"),
    FOLDER_NOT_EXIST(406,"文件夹不存在")
    ;



    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
