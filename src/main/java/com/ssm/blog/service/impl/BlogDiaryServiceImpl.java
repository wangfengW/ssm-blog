package com.ssm.blog.service.impl;

import com.ssm.blog.dao.BlogDiaryDAO;
import com.ssm.blog.pojo.BlogDiary;
import com.ssm.blog.service.BlogDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogDiaryServiceImpl implements BlogDiaryService {
    @Autowired
    private BlogDiaryDAO blogDiaryDAO;

    @Override
    public void addDiary(BlogDiary diary) {
        blogDiaryDAO.addDiary(diary);
    }

    @Override
    public List<BlogDiary> getAllDiaryList(Integer userId) {
        return blogDiaryDAO.getAllDiaryList(userId);
    }
}
