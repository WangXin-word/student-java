package com.example.student.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.dao.SysUserDao;
import com.example.student.entity.SysUserEntity;
import com.example.student.service.SysUserService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    @GetMapping("/getUserList")
    public Page getUserInfo(IPage<SysUserEntity> ipage){
        return sysUserService.getStudentList(ipage);
    }

}
