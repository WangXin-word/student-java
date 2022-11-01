package com.example.student.controller;

import com.example.student.dao.MenuDao;
import com.example.student.service.IndexService;
import com.example.student.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Repository
@RestController
@RequestMapping("/api/index")
@Slf4j
public class IndexController {

    @Resource
    private IndexService indexService;

    /**
     * 获取列表
     */
    @GetMapping("/list")
    public Object listHeader(){
        return indexService.listHeader();
    }
}
