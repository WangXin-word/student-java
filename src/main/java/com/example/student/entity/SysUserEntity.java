package com.example.student.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")

public class SysUserEntity {

    //主键Id
    @TableId("id")
    private Long id;

    @TableField("name")
    private String name;

    @TableField("role_id")
    private Long roleId;

    @TableField("password")
    private String password;


    @TableField("avtar_id")
    private Long avtarId;

    @TableField("class_id")
    private Long classId;

    @TableField("dormitory_id")
    private Long dormitoryId;


    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;
}
