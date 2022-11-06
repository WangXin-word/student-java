package com.example.student.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.dto.UserCourseDto;
import com.example.student.entity.CourseEntity;

public interface CourseService {
    Object add(CourseEntity courseEntity);

    Object update(CourseEntity courseEntity);

    Object deleted(Long id);

    IPage<UserCourseDto> list(IPage<UserCourseDto> query);
}
