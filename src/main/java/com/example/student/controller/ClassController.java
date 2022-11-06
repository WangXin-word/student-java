package com.example.student.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.entity.ClassEntity;

import com.example.student.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/page")
    public Page list(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        return classService.list(page,pageSize);
    }

    /**
     * 课程新增
     * @param classEntity
     * @return
     */
    @PostMapping("/add")
    public Object add(@RequestBody ClassEntity classEntity ){
        return classService.add(classEntity);
    }

    /**
     * 课程修改
     * @param classEntity
     * @return
     */
    @PostMapping("/update")
    public Object update(@RequestBody ClassEntity classEntity ){
        return classService.update(classEntity);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/deleted/{id}")
    public Object deleted(@PathVariable("id") Long id ){
        return classService.deleted(id);
    }
}
