package com.example.student.controller;

import com.example.student.dto.MenuDto;
import com.example.student.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public Object update(@RequestBody MenuDto menuDto){
        return menuService.update(menuDto);
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
