package com.example.student.utils;

import org.apache.ibatis.jdbc.Null;

import java.util.List;

public class isEnity {

    /**
     * 判断Strig是否为空
     */
    public static boolean  content(String data){
        if (data == null){
            return false;
        }
        return true;
    }

    /**
     * 判断id是否为空
     */
    public static boolean  content(Long data){
        if (data == null){
            return false;
        }
        return true;
    }


    /**
     * 判断List集合是否为空
     * @param data
     * @return
     */
    public static boolean  content(List data){
        if (data == null){
            return false;
        }
        return true;
    }

    /**
     * 参数null
     */
    public static boolean content(Null data){
        return false;
    }
}
