package com.example.student.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.student.dao.SysUserDao;
import com.example.student.dao.TokenDao;
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
import java.util.List;

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
                TokenDao tokenDao = new TokenDao();
                tokenDao.setId(sysMeaasgeEntitySql.getId());
                tokenDao.setName(sysMeaasgeEntitySql.getName());
                tokenDao.setNewDate(System.currentTimeMillis());
                String token = JSONObject.toJSONString(tokenDao);

//                String token = System.currentTimeMillis()+sysMeaasgeEntitySql.getName()+sysMeaasgeEntitySql.getId();
                String tokenAES = AESUtils.encrypt(token);
                log.info("登录人",sysMeaasgeEntitySql.getName(),"加密前的Token为",token);

                //整理好数据赋值到sysUserDao
                SysUserDao sysUserDao =  new SysUserDao();
                sysUserDao.setToken(tokenAES);
                sysUserDao.setName(sysMeaasgeEntitySql.getName());

                //通过拿到的avater_id去获取图片
                if (sysMeaasgeEntitySql.getAvtarId() != null){
                    QueryWrapper<PictureEntity> getAvtarWrapper = new QueryWrapper<>();
                    getAvtarWrapper.eq("id",sysMeaasgeEntitySql.getAvtarId());
                    PictureEntity pictureEntity = pictureMapper.selectOne(getAvtarWrapper);
                    sysUserDao.setAvtar(pictureEntity.getPictureUrl());
                }

                //通过拿到的class_id去获取班级
                if (sysMeaasgeEntitySql.getClassId() != null){
                    QueryWrapper<ClassEntity> getClassWrapper = new QueryWrapper<>();
                    getClassWrapper.eq("id",sysMeaasgeEntitySql.getClassId());
                    ClassEntity classEntity = classMapper.selectOne(getClassWrapper);
                    sysUserDao.setClassName(classEntity.getName());
                }

                //通过拿到的dormitory_id去获取宿舍
                if (sysMeaasgeEntitySql.getDormitoryId() != null){
                    QueryWrapper<DormitoryEntity> getDormitoryWrapper = new QueryWrapper<>();
                    getDormitoryWrapper.eq("id",sysMeaasgeEntitySql.getDormitoryId());
                    DormitoryEntity dormitoryEntity = dormitoryMapper.selectOne(getDormitoryWrapper);
                    sysUserDao.setDormitory(dormitoryEntity.getName());
                }

                String userInfoString = JSON.toJSONString(tokenDao);
                redisUtil.set("userInfo",userInfoString);
                return Result.success("登录成功",sysUserDao);
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
}
