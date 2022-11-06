package com.example.student.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.entity.ClassEntity;

import java.util.List;

public interface ClassService {
    Object add(ClassEntity classEntity);

    Object update(ClassEntity classEntity);

    Object deleted(Long id);

    Page list(int page, int pageSize);
}
