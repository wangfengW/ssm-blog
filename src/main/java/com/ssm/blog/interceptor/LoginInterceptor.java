package com.ssm.blog.interceptor;

import com.ssm.blog.util.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    //进入Controller之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("开始拦截");
        // 其他情况判断session中是否有key，有的话继续用户的操作
        System.out.println(request.getSession().getAttribute(Constants.SESSION_USER));
        if (request.getSession().getAttribute(Constants.SESSION_USER) != null) {
            return true;
        }
        // 最后的情况就是进入登录页面
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return false;
    }

}
