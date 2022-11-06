package com.example.student.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.entity.ClassEntity;
import com.example.student.entity.DormitoryEntity;
import com.example.student.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dormitory")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("/page")
    public Page list(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        return dormitoryService.list(page,pageSize);
    }

    /**
     * 课程新增
     * @param dormitoryEntity
     * @return
     */
    @PostMapping("/add")
    public Object add(@RequestBody DormitoryEntity dormitoryEntity ){
        return dormitoryService.add(dormitoryEntity);
    }

    /**
     * 课程修改
     * @param dormitoryEntity
     * @return
     */
    @PostMapping("/update")
    public Object update(@RequestBody DormitoryEntity dormitoryEntity ){
        return dormitoryService.update(dormitoryEntity);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/deleted/{id}")
    public Object deleted(@PathVariable("id") Long id ){
        return dormitoryService.deleted(id);
    }
}
