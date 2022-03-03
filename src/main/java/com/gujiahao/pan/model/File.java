package com.gujiahao.pan.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "文件")
@TableName("t_file")
public class File {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "file_id")
    @TableId(value = "file_id")
    private Long fileId;

    @ApiModelProperty(value = "user_id")
    @TableField(value = "user_id")
    private Long userId;

    @ApiModelProperty(value = "file_name")
    @TableField(value = "file_name")
    private String fileName;

    @ApiModelProperty(value = "file_size")
    @TableField(value = "file_size")
    private Long fileSize;

    @ApiModelProperty(value = "file_address")
    @TableField(value = "file_address")
    private String fileAddress;
}
