package com.example.student.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("scores")

public class ScoresEntity {

    //主键Id
    @TableId("id")
    private Long id;

    @TableField("course_id")
    private String courseId;

    @TableField("student_id")
    private String studentId;

    @TableField("teacher_id")
    private String teacherId;


    @TableField("score")
    private Long score;


    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;
}
