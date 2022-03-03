package com.gujiahao.pan.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户")
@TableName("t_user")
public class User {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id")
    private Long userId;

    @ApiModelProperty(value = "用户名")
    @TableField(value = "user_name")
    private String userName;

    @ApiModelProperty(value = "密码")
    @TableField("user_password")
    private String userPassword;

    @ApiModelProperty(value = "存储空间")
    @TableField("total_space")
    private Long totalSpace;

    @ApiModelProperty(value = "已用空间")
    @TableField("used_space")
    private Long usedSpace;

    @ApiModelProperty("token")
    @TableField(exist = false)
    private String token;
}
