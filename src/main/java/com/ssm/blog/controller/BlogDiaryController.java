package com.ssm.blog.controller;

import com.ssm.blog.pojo.BlogDiary;
import com.ssm.blog.pojo.BlogUser;
import com.ssm.blog.service.BlogDiaryService;
import com.ssm.blog.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/diary")
public class BlogDiaryController {

    @Autowired
    private BlogDiaryService blogDiaryService;

    @RequestMapping("/add.html")
    public String add(BlogDiary diary, HttpSession session) {
        BlogUser user = (BlogUser) session.getAttribute(Constants.SESSION_USER);
        diary.setUserId(user.getId());
        blogDiaryService.addDiary(diary);
        return "redirect:/diary/list.html?userId=" + user.getId();
    }

    @RequestMapping("/list.html")
    public String list(Model model, Integer userId) {
        List<BlogDiary> diaryList = blogDiaryService.getAllDiaryList(userId);
        model.addAttribute("diaryList", diaryList);
        return "diary/list";
    }
}
