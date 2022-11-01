package com.example.student.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
/**
 * 返回前端的用户信息
 */
public class SysUserDao {
    private String name;
    private String avtar;
    private String powerId;
    private String className;
    private String dormitory;
    private String token;

}
