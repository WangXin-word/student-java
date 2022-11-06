package com.example.student.service;

import com.example.student.dto.MenuDto;

public interface MenuService {
    Object update(MenuDto menuDto);
    Object delete(long id);
    Object list();
}
