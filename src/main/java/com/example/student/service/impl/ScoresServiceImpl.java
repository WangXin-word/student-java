package com.example.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.student.entity.ClassEntity;
import com.example.student.entity.ScoresEntity;
import com.example.student.mapper.ClassMapper;
import com.example.student.mapper.ScoresMapper;
import com.example.student.service.ClassService;
import com.example.student.service.ScoresService;
import com.example.student.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Transactional
@Service
@Slf4j
public class ScoresServiceImpl implements ScoresService {

    @Autowired
    private ScoresMapper scoresMapper;
    /**
     * 课程新增
     * @param scoresEntity
     * @return
     */
    @Override
    public Object add(ScoresEntity scoresEntity) {
        if (Objects.isNull(scoresEntity)){
            return "新增失败,检查入参";
        }
        try{
            scoresMapper.insert(scoresEntity);
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
    public Object update(ScoresEntity scoresEntity) {
        if (Objects.isNull(scoresEntity) || Objects.isNull(scoresEntity.getId())){
            return "修改失败,检查入参";
        }
        try{
            scoresMapper.updateById(scoresEntity);
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
            scoresMapper.deleteById(id);
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
        QueryWrapper<ScoresEntity> classEntityQueryWrapper = new QueryWrapper<>();
//        classEntityQueryWrapper.eq("name",name);
        try{
            Page page1 =  new Page();
            page1.setSize(pageSize);
            page1.setCurrent(page);
            return scoresMapper.selectPage(page1, classEntityQueryWrapper);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("查询失败");
        }
    }
}
