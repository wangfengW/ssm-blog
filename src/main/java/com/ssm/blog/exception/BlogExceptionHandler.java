package com.ssm.blog.exception;

import com.ssm.blog.util.Funcs;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class BlogExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String msg = e.getMessage();
        if (httpServletResponse.isCommitted()) {
            return null;
        }
        //如果是ajax请求就返回json数据
        if (Funcs.isAjax(httpServletRequest)) {
            Map<String, String> result = new HashMap<>();
            result.put("ex", msg);
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            return new ModelAndView(view, result);
        } else {//不是ajax就返回错误页面
            httpServletRequest.setAttribute("errorMsg", msg);
            return new ModelAndView("error");
        }
    }
}
