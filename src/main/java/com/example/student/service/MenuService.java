package com.example.student.service;

import com.example.student.dao.MenuDao;
import com.example.student.entity.MenuEntity;
import com.example.student.entity.SysUserEntity;
import com.example.student.utils.Result;

import java.util.Arrays;
import java.util.List;

public interface MenuService {
    Object update(MenuDao menuDao);
    Object delete(long id);
    Object list();
}
