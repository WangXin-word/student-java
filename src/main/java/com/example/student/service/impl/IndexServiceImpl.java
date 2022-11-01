package com.example.student.service.impl;

import com.example.student.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Service
@Slf4j
public class IndexServiceImpl  implements IndexService {

    /**
     * 学生数量
     * 教务人员数量
     * 老师数量
     * 学生平均成绩
     * @return
     */
    @Override
    public Object listHeader(){
        return null;
    }
}
