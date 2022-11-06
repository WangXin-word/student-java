package com.example.student.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class TokenDto {
    private Long id;
    private String name;
    private Long newDate;
    private Long roleId;
}
