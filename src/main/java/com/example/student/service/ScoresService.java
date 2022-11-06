package com.example.student.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.entity.ClassEntity;
import com.example.student.entity.ScoresEntity;

public interface ScoresService {
    Object add(ScoresEntity scoresEntity);

    Object update(ScoresEntity scoresEntity);

    Object deleted(Long id);

    Page list(int page, int pageSize);
}
