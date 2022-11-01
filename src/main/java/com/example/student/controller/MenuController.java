package com.example.student.controller;

import com.example.student.dao.MenuDao;
import com.example.student.entity.MenuEntity;
import com.example.student.entity.SysUserEntity;
import com.example.student.service.MenuService;
import com.example.student.service.SysUserService;
import com.example.student.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Repository
@RestController
@RequestMapping("/api/menu")
@Slf4j
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 修改
     */
    @PostMapping("/update")
    public Object update(@RequestBody MenuDao menuDao){
        return menuService.update(menuDao);
    }
    /**
     * 删除
     */
    @GetMapping("/delete")
    public Object delete(long id){
        return menuService.delete(id);
    }

    /**
     * 获取列表
     */
    @GetMapping("/list")
    public Object list(){
        return menuService.list();
    }
}
