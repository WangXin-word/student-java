package com.example.student.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class CoursePageDto {
    private Long Id;
    private String Name;
    private String teacherName;
    private String createTime;
    private String updateTime;
}
