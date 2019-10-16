package com.maplegroup.maplehotel.Intercepto;


import com.maplegroup.maplehotel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PowerInterceptor implements HandlerInterceptor {

    @Autowired
    private IUserService service;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = (String)(request.getSession().getAttribute("username"));
        if(service.getUserPower(username)<3){
            return true;
        }
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().print("<script language=\"javascript\">alert('权限不足！');window.location.href='../user/userInfo.do'</script>");
        return false;
    }
}
