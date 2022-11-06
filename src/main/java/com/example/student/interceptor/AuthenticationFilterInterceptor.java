package com.example.student.interceptor;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.student.dto.TokenDto;
import com.example.student.utils.AESUtils;
import com.example.student.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
public class AuthenticationFilterInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        //查看请求中是否存在token，如果不存在直接跳转到登陆页面
        String Authorization = request.getHeader("Authorization");
        if (!StringUtils.isEmpty(Authorization)){
            // 拿到前端token并解密
            String token =  Authorization.substring(5);
            log.info("打印Token="+token);
            String AesdecToken = AESUtils.decrypt(token);
            JSONObject jsonObject = JSONObject.parseObject(AesdecToken);
            log.info("token获取到的内容="+AesdecToken);

            String userInfo = redisUtil.get("userInfo");
            TokenDto redisUserInfo = JSON.parseObject(userInfo, TokenDto.class);
            log.info("redisUserInfo ==" +redisUserInfo);
            Long userId = redisUserInfo.getId();
            if ((userId + "").equals(jsonObject.get("id").toString())){
                return true;
            }else {
                response.sendRedirect(request.getServletContext().getContextPath()+"/token/expire");
                return false;
            }
        }else{
            response.sendRedirect(request.getServletContext().getContextPath()+"/token/expire");
            return false;
        }
    }
}
