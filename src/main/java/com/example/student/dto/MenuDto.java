package com.example.student.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class MenuDto {
    private Long id;
    private String name;
    private String meta;
    private Integer sortMenu;
}
