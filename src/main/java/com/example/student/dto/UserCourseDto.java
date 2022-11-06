package com.example.student.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserCourseDto implements Serializable {
    private String uName;
    private Long cId;
    private Long teacherId;
    private String cName;
    private String yearCourse;
    private Date createTime;
    private Date updateTime;

}
