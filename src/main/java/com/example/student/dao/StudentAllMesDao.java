package com.example.student.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class StudentAllMesDao {
    private String total;
    private String size;
    private String current;

}
