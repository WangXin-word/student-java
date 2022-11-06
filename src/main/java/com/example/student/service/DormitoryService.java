package com.example.student.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.entity.ClassEntity;
import com.example.student.entity.DormitoryEntity;

public interface DormitoryService {
    Object add(DormitoryEntity dormitoryEntity);

    Object update(DormitoryEntity dormitoryEntity);

    Object deleted(Long id);

    Page list(int page, int pageSize);
}
