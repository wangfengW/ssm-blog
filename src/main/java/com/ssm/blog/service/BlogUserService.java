package com.ssm.blog.service;

import com.ssm.blog.pojo.BlogUser;

public interface BlogUserService {
    void doRegist(BlogUser user);

    BlogUser doLogin(String userName, String password) throws Exception;

    BlogUser getUserByUserName(String userName);
}
