package com.ssm.blog.service;

import com.ssm.blog.pojo.BlogDiary;

import java.util.List;

public interface BlogDiaryService {
    void addDiary(BlogDiary diary);

    List<BlogDiary> getAllDiaryList(Integer userId);
}
