package com.example.student.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class StudentMessageDto {
    private String studengtAllNum;
    private String num;
}
