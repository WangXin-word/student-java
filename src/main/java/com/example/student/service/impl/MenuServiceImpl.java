package com.example.student.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.student.dto.MenuDto;
import com.example.student.dto.TokenDto;
import com.example.student.entity.*;
import com.example.student.mapper.MenuMapper;
import com.example.student.mapper.PowerMapper;
import com.example.student.mapper.SysUserMapper;
import com.example.student.service.MenuService;
import com.example.student.utils.RedisUtil;
import com.example.student.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
@Slf4j
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private PowerMapper powerMapper;


    @Autowired
    private RedisUtil redisUtil;


    @Override
    public Object update(MenuDto menuDto) {
        log.info("menuEntity"+ menuDto);
        try{
            MenuEntity menuEntity = new MenuEntity();
            menuEntity.setId(menuDto.getId());
            menuEntity.setName(menuDto.getName());
            menuEntity.setMeta(menuDto.getMeta());
            menuEntity.setSortMenu(menuDto.getSortMenu());
            menuMapper.updateById(menuEntity);
            return Result.success("success","菜单更新成功");
        }catch (Exception e){
            log.info("e"+ e);
            log.error("e"+e);
            throw e;
        }
    }

    @Override
    public Object delete(long id){
        menuMapper.deleteById(id);
        return Result.success("success","删除成功");
    }

    @Override
    public List<MenuEntity> list() {
//        拿到对应的角色
        String userInfo = redisUtil.get("userInfo");
        TokenDto redisUserInfo = JSON.parseObject(userInfo, TokenDto.class);
        Long userId = redisUserInfo.getId();
        SysUserEntity sysUserEntitySql = sysUserMapper.selectById(userId);

        //通过角色查询对应的权限
        QueryWrapper getPowerQueryWrapper = new QueryWrapper();
        getPowerQueryWrapper.eq("role_id",sysUserEntitySql.getRoleId());
        List<PowerEntity> powerList = powerMapper.selectList(getPowerQueryWrapper);

        //通过权限表集合拿到对应的菜单
        List<Long> menuObjectsId = new ArrayList<>();
        for(PowerEntity powerEntity:powerList){
            menuObjectsId.add(powerEntity.getMenuId());
        }
        log.info("menuObjectsId ==" + menuObjectsId);
        if (menuObjectsId.size() > 0){
            List<MenuEntity> menuEntitiesSQL = menuMapper.selectBatchIds(menuObjectsId);
            Collections.sort(menuEntitiesSQL,(a,b)->{
                log.info("a === "+a);
                log.info("b === "+b);
                return b.getSortMenu() - a.getSortMenu();
            });
            return menuEntitiesSQL;
        }

        return null;
    }

}
