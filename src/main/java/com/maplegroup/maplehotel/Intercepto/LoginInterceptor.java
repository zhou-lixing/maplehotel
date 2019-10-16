package com.maplegroup.maplehotel.Intercepto;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = (String)(request.getSession().getAttribute("username"));
        if(!username.equals("")){
            return true;
        }
        return false;
    }
}