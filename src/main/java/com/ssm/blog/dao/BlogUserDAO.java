package com.ssm.blog.dao;

import com.ssm.blog.pojo.BlogUser;

public interface BlogUserDAO {
    void addUser(BlogUser user);

    BlogUser getUserByUserName(String userName);
}
