package com.example.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.entity.ClassEntity;
import com.example.student.entity.SysUserEntity;
import com.example.student.mapper.ClassMapper;
import com.example.student.service.ClassService;
import com.example.student.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
@Slf4j
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;
    /**
     * 课程新增
     * @param classEntity
     * @return
     */
    @Override
    public Object add(ClassEntity classEntity) {
        if (Objects.isNull(classEntity)){
            return "新增失败,检查入参";
        }
        try{
            classMapper.insert(classEntity);
            return Result.success("200","添加成功");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("新增失败");
        }

    }

    /**
     *  课程修改
     * @param classEntity
     * @return
     */
    @Override
    public Object update(ClassEntity classEntity) {
        if (Objects.isNull(classEntity) || Objects.isNull(classEntity.getId())){
            return "修改失败,检查入参";
        }
        try{
            classMapper.updateById(classEntity);
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
            classMapper.deleteById(id);
            return Result.success("200","删除成功");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("删除失败");
        }
    }

    /**
     * 列表查询
     * @param page
     * @param pageSize
     * @param
     * @return
     */
    @Override
    public Page list(int page, int pageSize) {
        QueryWrapper<ClassEntity> classEntityQueryWrapper = new QueryWrapper<>();
//        classEntityQueryWrapper.eq("name",name);
        try{
            Page page1 =  new Page();
            page1.setSize(pageSize);
            page1.setCurrent(page);
            return classMapper.selectPage(page1, classEntityQueryWrapper);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("查询失败");
        }
    }
}
