package com.ssm.blog.dao;

import com.ssm.blog.pojo.BlogDiary;

import java.util.List;

public interface BlogDiaryDAO {
    void addDiary(BlogDiary diary);

    List<BlogDiary> getAllDiaryList(Integer userId);
}
