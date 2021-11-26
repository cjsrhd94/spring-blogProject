package com.kim.controller;

import com.kim.domain.CategoryVO;
import com.kim.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/blogAdmin_category_insert.do")
    public String blogAdmin_category_insert(CategoryVO vo) {
        categoryService.insertCategory(vo);
        System.out.println("---> 카테고리 생성 완료");
        return "forward:/blogAdminView_category.do";
    }

    @RequestMapping("/blogAdmin_category_update.do")
    public String blogAdmin_category_update(CategoryVO vo) {
        categoryService.updateCategory(vo);
        System.out.println("---> 카테고리 수정 완료");
        return "forward:/blogAdminView_category.do";
    }

    @RequestMapping("/blogAdminView_category_update.do")
    public String blogAdminView_category_update(CategoryVO vo, Model model) {
        model.addAttribute("category_select", categoryService.getCategory(vo));
        return "forward:/blogAdminView_category.do";
    }

    @RequestMapping("/blogAdmin_category_delete.do")
    public String blogAdmin_category_delete(CategoryVO vo) {
        categoryService.deleteCategory(vo);
        System.out.println("---> 카테고리 삭제 완료");
        return "forward:/blogAdminView_category.do";
    }
}
