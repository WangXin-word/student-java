package com.example.student.utils;

import java.util.List;

/**
 * 封装返回数据的公共类
 * @param <T>
 */
public class Result <T> {
    private int code;  //状态码
    private String msg;  //返回的信息
    private T data;     //返回的数据
    private List cont;

    /**
     * 成功的时候调用（有数据）
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 成功的时候调用（无数据）
     */
    public static <T> Result<T> success(){
        return new Result<>();
    }

    /**
     * 请求成功，参数有误
     */

    public static <T> Result<T> success(String msg,T data){
        return new Result<T>(msg,data);
    }

    public static <T> Result<T> success(Integer code, String msg){
        return new Result<T>(code,msg);
    }

    /**
     * 请求成功 参数为list集合
     * @param data
     */

    public static <T> Result<T> success(Integer code, String msg, List data){
        return new Result<T>(code,msg,data);
    }


    /**
     * 异常的时候调用（有msg参数）
     * @param data
     */
    public static <T> Result<T> error(String msg){
        return new Result<T>(msg);
    }

    /**
     * 特殊异常自定义code
     */
    public static <T> Result<T> error(Integer code, String msg){
        return new Result<T>(code,msg);
    }

    /**
     * 异常的时候调用（无msg参数）
     * @param data
     */
    public static <T> Result<T> error(){
        return new Result<T>("error");
    }

    private Result(T data){
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    private Result(){
        this.code = 200;
        this.msg = "success";
    }

    private Result(String msg,T data){
        this.code = 200;
        this.msg = "msg";
        this.data = data;
    }

    private Result(String msg){
        this.code = 400;
        this.msg = msg;
    }

    private Result(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private Result(Integer code,String msg,List data){
        this.code = code;
        this.msg = msg;
        this.cont = data;
    }

    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

    public T getData(){
        return data;
    }

}
