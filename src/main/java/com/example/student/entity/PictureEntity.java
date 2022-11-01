package com.example.student.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("picture")

public class PictureEntity {

    //主键Id
    @TableId("id")
    private Long id;

    //图片地址
    @TableField("picture_url")
    private String pictureUrl;

    //上传人的id
    @TableField("update_id")
    private Long updateId;

    //创建时间
    @TableField("create_time")
    private String createTime;

    //更新时间时间
    @TableField("update_time")
    private String updateTime;
}
