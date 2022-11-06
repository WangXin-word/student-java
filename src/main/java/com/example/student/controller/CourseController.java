package com.example.student.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.dto.UserCourseDto;
import com.example.student.entity.ClassEntity;
import com.example.student.entity.CourseEntity;
import com.example.student.service.ClassService;
import com.example.student.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/page")
//    public Page<UserCourseDto> list(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
    public IPage<UserCourseDto> list(IPage<UserCourseDto> query){
        query.setSize(10);
        query.setCurrent(1);
//        Page<UserCourseDto> page1 = new Page<>();
//        page1.setSize(10);
//        page1.setCurrent(1);
        IPage<UserCourseDto> iPage = courseService.list(query);
        log.info("page",iPage);
        return iPage;
    }

    /**
     * 课程新增
     * @param courseEntity
     * @return
     */
    @PostMapping("/add")
    public Object add(@RequestBody CourseEntity courseEntity){
        return courseService.add(courseEntity);
    }

    /**
     * 课程修改
     * @param courseEntity
     * @return
     */
    @PostMapping("/update")
    public Object update(@RequestBody CourseEntity courseEntity ){
        return courseService.update(courseEntity);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/deleted/{id}")
    public Object deleted(@PathVariable("id") Long id ){
        return courseService.deleted(id);
    }
}
