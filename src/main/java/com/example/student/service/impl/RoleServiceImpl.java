package com.example.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.student.entity.MenuEntity;
import com.example.student.entity.RoleEntity;
import com.example.student.entity.SysUserEntity;
import com.example.student.mapper.RoleMapper;
import com.example.student.mapper.SysUserMapper;
import com.example.student.service.RoleService;
import com.example.student.service.SysUserService;
import com.example.student.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Transactional
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {
    @Resource
    private RoleMapper roleMapper;


    @Override
    public Object getList(){
        return Result.success("success",roleMapper.selectByMap(null));
    }
}
