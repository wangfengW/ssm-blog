package com.ssm.blog.controller;

import com.ssm.blog.pojo.BlogUser;
import com.ssm.blog.service.BlogUserService;
import com.ssm.blog.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class BlogUserController {

    @Autowired
    private BlogUserService blogUserService;

    @RequestMapping("/regist.html")
    public String regist(String userName, String password, String repwd) {
        if (!password.equals(repwd)) {
            return "error";
        }
        BlogUser user = new BlogUser();
        user.setPassword(password);
        user.setUserName(userName);
        blogUserService.doRegist(user);
        return "index";
    }

    @RequestMapping("/login.html")
    public String login(String userName, String password, HttpSession session) throws Exception {
        BlogUser user = blogUserService.doLogin(userName, password);
        session.setAttribute(Constants.SESSION_USER, user);
        return "index";
    }

    @RequestMapping("/check.html")
    @ResponseBody
    public Map<String, Object> checkUserName(String userName) {
        Map<String, Object> result = new HashMap<>();
        BlogUser user = blogUserService.getUserByUserName(userName);
        if (user != null) {
            result.put("status", false);
            result.put("msg", "用户名已存在");
        } else {
            result.put("status", true);
            result.put("msg", "用户名可以使用");
        }
        return result;
    }

}
