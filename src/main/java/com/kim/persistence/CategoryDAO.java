package com.kim.persistence;

import com.kim.domain.CategoryVO;

import java.util.List;

public interface CategoryDAO {
    // 카테고리 등록
    void insertCategory(CategoryVO vo);

    // 카테고리 수정
    void updateCategory(CategoryVO vo);

    // 카테고리 삭제
    void deleteCategory(CategoryVO vo);

    // 카테고리 전체 목록 조회
    List<CategoryVO> getCategoryList(CategoryVO vo);
}
