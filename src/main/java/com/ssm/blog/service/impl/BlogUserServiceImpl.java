package com.ssm.blog.service.impl;

import com.ssm.blog.dao.BlogUserDAO;
import com.ssm.blog.pojo.BlogUser;
import com.ssm.blog.service.BlogUserService;
import com.ssm.blog.util.Constants;
import com.ssm.blog.util.Funcs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogUserServiceImpl implements BlogUserService {
    @Autowired
    private BlogUserDAO blogUserDAO;

    @Override
    public void doRegist(BlogUser user) {
        String password = user.getPassword() + Constants.PASSWORD_SALT_KEY;
        user.setPassword(Funcs.MD5(password));
        blogUserDAO.addUser(user);
    }

    @Override
    public BlogUser doLogin(String userName, String password) throws Exception {
        BlogUser user = blogUserDAO.getUserByUserName(userName);
        if (user != null && Funcs.MD5(password + Constants.PASSWORD_SALT_KEY).equals(user.getPassword())) {
            return user;
        }
        throw new Exception("用户名或密码错误");
    }

    @Override
    public BlogUser getUserByUserName(String userName) {
        return blogUserDAO.getUserByUserName(userName);
    }
}
