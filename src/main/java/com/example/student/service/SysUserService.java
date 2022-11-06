package com.example.student.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.entity.SysUserEntity;

import java.util.List;

public interface SysUserService {
    Object login(SysUserEntity sysUserEntity);
    Page getStudentList(IPage<SysUserEntity> ipage);
    Page getSysList(int page,int pageSize);
}
