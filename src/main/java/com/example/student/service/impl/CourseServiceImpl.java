package com.example.student.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.dto.UserCourseDto;
import com.example.student.entity.CourseEntity;
import com.example.student.mapper.CourseMapper;
import com.example.student.service.CourseService;
import com.example.student.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Transactional
@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    /**
     * 课程新增
     * @param courseEntity
     * @return
     */
    @Override
    public Object add(CourseEntity courseEntity) {
        if (Objects.isNull(courseEntity)){
            return "新增失败,检查入参";
        }
        try{
            courseMapper.insert(courseEntity);
            return Result.success("200","添加成功");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("新增失败");
        }

    }

    /**
     *  课程修改
     * @param courseEntity
     * @return
     */
    @Override
    public Object update(CourseEntity courseEntity) {
        if (Objects.isNull(courseEntity) || Objects.isNull(courseEntity.getId())){
            return "修改失败,检查入参";
        }
        try{
            courseMapper.updateById(courseEntity);
            return Result.success("200","修改成功");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public Object deleted(Long id) {
        if (Objects.isNull(id)){
            return "删除失败，入参为空";
        }
        try{
            courseMapper.deleteById(id);
            return Result.success("200","删除成功");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("删除失败");
        }
    }

    /**
     * 列表查询
     * @param
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public IPage<UserCourseDto> list(IPage<UserCourseDto> query) {
//        try{
        return courseMapper.list(query);
//        }catch (Exception e){
//            log.error(e.getMessage());
//            throw new RuntimeException("查询失败");
//        }
    }
}
