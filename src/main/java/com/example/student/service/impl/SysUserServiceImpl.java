package com.example.student.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.student.dto.SysUserDto;
import com.example.student.dto.TokenDto;
import com.example.student.entity.ClassEntity;
import com.example.student.entity.DormitoryEntity;
import com.example.student.entity.PictureEntity;
import com.example.student.entity.SysUserEntity;
import com.example.student.mapper.ClassMapper;
import com.example.student.mapper.DormitoryMapper;
import com.example.student.mapper.PictureMapper;
import com.example.student.mapper.SysUserMapper;
import com.example.student.service.SysUserService;
import com.example.student.utils.AESUtils;
import com.example.student.utils.RedisUtil;
import com.example.student.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {
    private final static String ENCODE = "GBK";
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private PictureMapper pictureMapper;
    @Resource
    private ClassMapper classMapper;
    @Resource
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private RedisUtil redisUtil;


    @Override
    public Object login(SysUserEntity sysUserEntity) {
        //首先判断是否存在该用户名
        log.info("前端传递的数据"+ sysUserEntity);
        QueryWrapper<SysUserEntity> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("name", sysUserEntity.getName());
        SysUserEntity sysMeaasgeEntitySql = sysUserMapper.selectOne(objectQueryWrapper);
        log.info("数据库查询到的内容"+sysMeaasgeEntitySql);
        if (sysMeaasgeEntitySql == null){
            return Result.success(201,"用户信息错误");
        }else{
            if (sysUserEntity.getPassword().equals(sysMeaasgeEntitySql.getPassword())){
                TokenDto tokenDto = new TokenDto();
                tokenDto.setId(sysMeaasgeEntitySql.getId());
                tokenDto.setName(sysMeaasgeEntitySql.getName());
                tokenDto.setNewDate(System.currentTimeMillis());
//                tokenDto.setRoleId(sysMeaasgeEntitySql.getRoleId());
                String token = JSONObject.toJSONString(tokenDto);

//                String token = System.currentTimeMillis()+sysMeaasgeEntitySql.getName()+sysMeaasgeEntitySql.getId();
                String tokenAES = AESUtils.encrypt(token);
                log.info("登录人",sysMeaasgeEntitySql.getName(),"加密前的Token为",token);

                //整理好数据赋值到sysUserDao
                SysUserDto sysUserDto =  new SysUserDto();
                sysUserDto.setToken(tokenAES);
                sysUserDto.setName(sysMeaasgeEntitySql.getName());
                sysUserDto.setRoleId(sysMeaasgeEntitySql.getRoleId());

                //通过拿到的avater_id去获取图片
                if (sysMeaasgeEntitySql.getAvtarId() != null){
                    QueryWrapper<PictureEntity> getAvtarWrapper = new QueryWrapper<>();
                    getAvtarWrapper.eq("id",sysMeaasgeEntitySql.getAvtarId());
                    PictureEntity pictureEntity = pictureMapper.selectOne(getAvtarWrapper);
                    sysUserDto.setAvtar(pictureEntity.getPictureUrl());
                }

                //通过拿到的class_id去获取班级
                if (sysMeaasgeEntitySql.getClassId() != null){
                    QueryWrapper<ClassEntity> getClassWrapper = new QueryWrapper<>();
                    getClassWrapper.eq("id",sysMeaasgeEntitySql.getClassId());
                    ClassEntity classEntity = classMapper.selectOne(getClassWrapper);
                    sysUserDto.setClassName(classEntity.getName());
                }

                //通过拿到的dormitory_id去获取宿舍
                if (sysMeaasgeEntitySql.getDormitoryId() != null){
                    QueryWrapper<DormitoryEntity> getDormitoryWrapper = new QueryWrapper<>();
                    getDormitoryWrapper.eq("id",sysMeaasgeEntitySql.getDormitoryId());
                    DormitoryEntity dormitoryEntity = dormitoryMapper.selectOne(getDormitoryWrapper);
                    sysUserDto.setDormitory(dormitoryEntity.getName());
                }

                String userInfoString = JSON.toJSONString(tokenDto);
                redisUtil.set("userInfo",userInfoString);
                return Result.success("登录成功", sysUserDto);
            }else {
                return Result.success(201,"密码错误，请重新登录");
            }
        }

    }


    @Override
    public Page<SysUserEntity> getStudentList(IPage<SysUserEntity> ipage) {
        QueryWrapper<SysUserEntity> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("role_id",4);
        ipage = new Page<>(0, 10);


        return (Page<SysUserEntity>)sysUserMapper.selectPage(ipage, objectQueryWrapper);
    }




    /**
     * 用户信息分页列表
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public Page getSysList(int page, int pageSize) {
        QueryWrapper<SysUserEntity> classEntityQueryWrapper = new QueryWrapper<>();
        classEntityQueryWrapper.ne("role_id",4);
        try{
            Page page1 =  new Page();
            page1.setSize(pageSize);
            page1.setCurrent(page);
            return sysUserMapper.selectPage(page1, classEntityQueryWrapper);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException("查询失败");
        }
    }



}
