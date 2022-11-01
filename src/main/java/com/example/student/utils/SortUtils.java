package com.example.student.utils;

import com.example.student.entity.MenuEntity;

import java.util.List;

public class SortUtils {
    /**
     * 给菜单写的排序方法
     * @param menuEntities
     * @return
     */
    public List<MenuEntity> sortFunction(List<MenuEntity> menuEntities){

        for (int i = 0; i < menuEntities.size(); i++) {
             menuEntities.get(i).getSortMenu();
        }
        return null;
    }
}
