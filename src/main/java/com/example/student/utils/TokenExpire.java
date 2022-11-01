package com.example.student.utils;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
@RestController
@RequestMapping("/token")
public class TokenExpire {
    @GetMapping("/expire")
    public Object Expire(){
        return Result.success(401,"token失效，请重新登陆");
    }
}
