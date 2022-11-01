package com.example.student.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("role")
public class RoleEntity {
    //主键Id
    @TableId("id")
    private Long id;

    @TableField("name")
    private String name;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;
}
