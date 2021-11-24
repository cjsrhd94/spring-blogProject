package com.kim.controller;

import com.kim.domain.CategoryVO;
import com.kim.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/blogAdmin_category_insert.do")
    public String blogAdmin_category_insert(CategoryVO vo){
        categoryService.insertCategory(vo);
        return "forward:/blogAdminView_category.do";
    }

    @RequestMapping("/blogAdmin_category_update.do")
    public String blogAdmin_category_update(CategoryVO vo){
        categoryService.updateCategory(vo);
        return "forward:/blogAdminView_category.do";
    }

    @RequestMapping("/blogAdmin_category_delete.do")
    public String blogAdmin_category_delete(CategoryVO vo){
        categoryService.deleteCategory(vo);
        return "forward:/blogAdminView_category.do";
    }
}
