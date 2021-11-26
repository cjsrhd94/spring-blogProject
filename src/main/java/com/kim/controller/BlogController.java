package com.kim.controller;

import com.kim.domain.BlogVO;
import com.kim.domain.CategoryVO;
import com.kim.domain.UserVO;
import com.kim.service.BlogService;
import com.kim.service.BoardService;
import com.kim.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BoardService boardService;

    @RequestMapping("/")
    public String root(UserVO vo, Model model) {
        model.addAttribute("blog", blogService.getUserBlog(vo));
        return "forward:index.do";
    }

    @RequestMapping("/index.do")
    public String index(BlogVO vo, Model model) {
        if (vo.getSearchCondition() == null) vo.setSearchCondition("blogName");
        if (vo.getSearchKeyword() == null) vo.setSearchKeyword("");

        model.addAttribute("search", vo);
        return "forward:index.jsp";
    }

    @RequestMapping("/searchBlog.do")
    public String searchBlog(BlogVO vo, Model model){
        System.out.println("블로그 목록 검색 기능 처리");
        model.addAttribute("blogInfo", blogService.getBlogInfo(vo));
        model.addAttribute("search", vo);
        return "forward:/";
    }

    @RequestMapping("/blogCreateView.do")
    public String blogCreateView() {
        return "blogcreate";
    }

    @RequestMapping("/blogCreate.do")
    public String blogCreate(BlogVO vo) {
        blogService.insertBlog(vo);
        return "forward:/";
    }

    @RequestMapping("/blogMainView.do")
    public String blogMainView(BlogVO blogVO, CategoryVO categoryVO, Model model) {
        model.addAttribute("blog", blogService.getBlog(blogVO));
        model.addAttribute("categoryList", categoryService.getCategoryList(categoryVO));
        model.addAttribute("boardInfo", boardService.getBoardInfo(categoryVO));
        return "forward:/WEB-INF/views/blogmain.jsp";
    }

    @RequestMapping("/blogAdminView_basic.do")
    public String blogAdminView_basic(BlogVO vo, Model model) {
        model.addAttribute("blog", blogService.getBlog(vo));
        return "blogadmin_basic";
    }

    @RequestMapping("/blogAdmin_basic_update.do")
    public String blogAdmin_basic_update(BlogVO vo, Model model) {
        blogService.updateBlog(vo);
        model.addAttribute("blog", blogService.getBlog(vo));
        return "forward:/blogMainView.do";
    }

    @RequestMapping("/blogAdminView_category.do")
    public String blogAdminView_category(BlogVO blogVO, CategoryVO categoryVO, Model model) {
        model.addAttribute("blog", blogService.getBlog(blogVO));
        model.addAttribute("categoryList", categoryService.getCategoryList(categoryVO));
        return "blogadmin_category";
    }

    @RequestMapping("/adminPostView.do")
    public String adminPostView(BlogVO blogVO, CategoryVO categoryVO, Model model) {
        model.addAttribute("blog", blogService.getBlog(blogVO));
        model.addAttribute("categoryList", categoryService.getCategoryList(categoryVO));
        return "adminpost";
    }

    @RequestMapping("/requestDeleteBlog.do")
    public String requestDeleteBlog(BlogVO vo){
        blogService.requestDeleteBlog(vo);
        return "forward:/";
    }

    @RequestMapping("/deleteBlog.do")
    public String deleteBlog(BlogVO vo){
        blogService.deleteBlog(vo);
        return "forward:/";
    }

}
