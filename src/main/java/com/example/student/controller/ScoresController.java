package com.example.student.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Repository
@RestController
@RequestMapping("/api/scores")
public class ScoresController {
    @Autowired
    private ScoresService scoresService;

    @GetMapping("/page")
    public Page list(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        return scoresService.list(page,pageSize);
    }
}
