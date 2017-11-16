package com.ssm.blog.service;

import com.github.pagehelper.PageInfo;
import com.ssm.blog.pojo.BlogShuo;

public interface BlogShuoService {
    void addBlogShuo(BlogShuo shuo);

    PageInfo<BlogShuo> getShuoList(Integer userId, Integer pageNo);
}
