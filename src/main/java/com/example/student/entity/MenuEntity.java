package com.example.student.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("menu")
public class MenuEntity {

    //主键Id
    @TableId("id")
    private Long id;

    //路径
    @TableField("path")
    private String path;

    //名称
    @TableField("name")
    private String name;

    // 排序
    @TableField("sort_menu")
    private Integer sortMenu;

    //信息元
    @TableField("meta")
    private String meta;

    //图标
    @TableField("icon")
    private String icon;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;

}
