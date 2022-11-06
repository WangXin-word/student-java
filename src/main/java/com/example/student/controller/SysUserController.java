package com.example.student.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.entity.SysUserEntity;
import com.example.student.service.SysUserService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Repository
@RestController
@RequestMapping("/api/system")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 用户登录
     * @param sysUserEntity
     * @return
     */
    @PostMapping("/login")
    public Object login(@RequestBody SysUserEntity sysUserEntity ){
        return sysUserService.login(sysUserEntity);
    }

    /**
     * 获取学生列表
     * @param ipage
     * @return
     */
    @GetMapping("/getStudentList")
    public Page getStudentInfo(IPage<SysUserEntity> ipage){
        return sysUserService.getStudentList(ipage);
    }

    /**
     * 获取学校工作人员列表
     * @param page
     * @return
     */
    @GetMapping("/getSysPage")
    public Page getSysList(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        return sysUserService.getSysList(page,pageSize);
    }

}
