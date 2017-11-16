package com.ssm.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.blog.dao.BlogShuoDAO;
import com.ssm.blog.pojo.BlogShuo;
import com.ssm.blog.service.BlogShuoService;
import com.ssm.blog.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogShuoServiceImpl implements BlogShuoService {
    @Autowired
    private BlogShuoDAO blogShuoDAO;

    @Override
    public void addBlogShuo(BlogShuo shuo) {
        blogShuoDAO.addBlogShuo(shuo);
    }

    @Override
    public PageInfo<BlogShuo> getShuoList(Integer userId, Integer pageNo) {
        PageHelper.startPage(pageNo, Constants.DIARY_PAGE_SIZE, "id desc");
        List<BlogShuo> shuoList = blogShuoDAO.getShuoList(userId);
        PageInfo<BlogShuo> page = new PageInfo<>(shuoList, 5);


        return page;
    }

    public static void main(String[] args) {
        int navNum = 5;
        int middle = navNum / 2;
        int pageNum = 2;
        int totalPage = 10;
        int startPage = pageNum - middle;
        int endPage = pageNum + middle;
        if (navNum > totalPage) {
            startPage = 1;
            endPage = totalPage;
        } else {
            if (startPage < 1) {
                startPage = 1;
            }
            if (endPage > totalPage) {
                endPage = totalPage;
            }
            if (endPage < navNum) {
                endPage = navNum;
            }
            if (endPage - startPage < navNum) {
                startPage = endPage - navNum + 1;
            }
        }
        System.out.println(startPage);
        System.out.println(endPage);
    }
}
