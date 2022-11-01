package com.example.student.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class StudentMessageDao {
    private String name;
    private String num;
}
