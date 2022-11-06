package com.example.student.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class StudentAllMesDto {
    private String total;
    private String size;
    private String current;

}
