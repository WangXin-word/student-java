package com.example.student.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Time;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class TokenDao {
    private Long id;
    private String name;
    private Long newDate;
}
