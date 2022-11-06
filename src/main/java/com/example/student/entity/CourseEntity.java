package com.example.student.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course")
public class CourseEntity {
    //主键Id
    @TableId("id")
    private Long id;

    @TableField("teacher_id")
    private Long teacherId;

    @TableField("cname")
    private String cname;

    @TableField("year_course")
    private String yearCourse;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;
}
