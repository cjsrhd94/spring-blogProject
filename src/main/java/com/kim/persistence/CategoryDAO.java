package com.kim.persistence;

import com.kim.domain.BlogVO;
import com.kim.domain.CategoryVO;

import java.util.List;

public interface CategoryDAO {
    // 카테고리 등록
    void insertCategory(CategoryVO vo);

    // 블로그 생성시 미분류 카테고리를 등록
    void insertCategory_unclassified(BlogVO blogVO);

    // 카테고리 수정
    void updateCategory(CategoryVO vo);

    // 카테고리 삭제
    void deleteCategory(CategoryVO vo);

    // 카테고리 상세 조회
    CategoryVO getCategory(CategoryVO vo);

    // 카테고리 전체 목록 조회
    List<CategoryVO> getCategoryList(CategoryVO vo);
}
