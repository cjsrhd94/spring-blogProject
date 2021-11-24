package com.kim.service;

import com.kim.domain.CategoryVO;
import com.kim.persistence.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    // 카테고리 등록
    @Override
    public void insertCategory(CategoryVO vo) {
        categoryDAO.insertCategory(vo);
    }

    // 카테고리 수정
    @Override
    public void updateCategory(CategoryVO vo) {
        categoryDAO.updateCategory(vo);
    }

    // 카테고리 삭제
    @Override
    public void deleteCategory(CategoryVO vo) {
        categoryDAO.deleteCategory(vo);
    }

    // 카테고리 상세 조회
    @Override
    public CategoryVO getCategory(CategoryVO vo) {
        return categoryDAO.getCategory(vo);
    }

    // 카테고리 전체 목록 조회
    @Override
    public List<CategoryVO> getCategoryList(CategoryVO vo) {
        return categoryDAO.getCategoryList(vo);
    }
}
