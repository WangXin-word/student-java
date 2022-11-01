package com.example.student.controller;

import com.example.student.entity.SysUserEntity;
import com.example.student.service.RoleService;
import com.example.student.service.SysUserService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Repository
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 获取角色列表
     * @return
     */
    @GetMapping("getRole")
    public Object getRole(){
        return roleService.getList();
    }

}
