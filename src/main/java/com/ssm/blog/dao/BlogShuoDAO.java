package com.ssm.blog.dao;

import com.ssm.blog.pojo.BlogShuo;

import java.util.List;

public interface BlogShuoDAO {
    void addBlogShuo(BlogShuo shuo);

    List<BlogShuo> getShuoList(Integer userId);
}
