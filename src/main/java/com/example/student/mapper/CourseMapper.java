package com.example.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.dto.CoursePageDto;
import com.example.student.dto.UserCourseDto;
import com.example.student.entity.CourseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<CourseEntity> {
    List<CoursePageDto> CoursePageList();

    IPage<UserCourseDto> list(IPage<UserCourseDto> query);
}
