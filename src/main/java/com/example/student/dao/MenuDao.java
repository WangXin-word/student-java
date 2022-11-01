package com.example.student.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class MenuDao {
    private Long id;
    private String name;
    private String meta;
    private Integer sortMenu;
}
