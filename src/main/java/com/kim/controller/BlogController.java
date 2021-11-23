package com.kim.controller;

import com.kim.domain.BlogVO;
import com.kim.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class giBlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/")
    public String root(){
        return "forward:index.do";
    }

    @RequestMapping("/index.do")
    public String index(BlogVO vo, HttpSession session, Model model){
        System.out.println("블로그 목록 검색 기능 처리");
        if (vo.getSearchCondition() == null) vo.setSearchCondition("blogName");
        if (vo.getSearchKeyword() == null) vo.setSearchKeyword("");
        model.addAttribute("blogList", blogService.getBlogList(vo));
        model.addAttribute("search", vo);
        return "forward:index.jsp";
    }

    @RequestMapping("/blogCreateView.do")
    public String blogCreateView() {
        return "blogcreate";
    }

    @RequestMapping("/blogCreate.do")
    public String blogCreate(BlogVO vo, HttpSession session) {
        blogService.insertBlog(vo);
        return "forward:/index.do";
    }

    @RequestMapping("/blogMainView.do")
    public String blogMainView(BlogVO vo, Model model){
        model.addAttribute("blog", blogService.getBlog(vo));
        return "blogmain";
    }

}
