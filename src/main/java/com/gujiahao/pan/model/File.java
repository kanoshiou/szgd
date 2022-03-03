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

    @ApiModelProperty(value = "文件id")
    @TableId(value = "file_id")
    private Long fileId;

    @ApiModelProperty(value = "用户id")
    @TableField(value = "user_id")
    private Long userId;

    @ApiModelProperty(value = "文件名")
    @TableField(value = "file_name")
    private String fileName;

    @ApiModelProperty(value = "文件类型")
    @TableField(value = "file_type")
    private String fileType;

    @ApiModelProperty(value = "文件大小")
    @TableField(value = "file_size")
    private Long fileSize;

    @ApiModelProperty(value = "文件路径")
    @TableField(value = "file_path")
    private String filePath;

    @ApiModelProperty(value = "文件MD5")
    @TableField(value = "file_MD5")
    private String fileMD5;


}
