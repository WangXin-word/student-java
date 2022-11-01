package com.example.student.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("power")
public class PowerEntity {
    //主键Id
    @TableId("id")
    private Long id;

    @TableField("role_id")
    private String roleId;

    @TableField("menu_id")
    private Long menuId;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;
}
