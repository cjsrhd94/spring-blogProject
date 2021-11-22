package com.kim.persistence;

import com.kim.domain.CategoryVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryDAOJDBCTest {

    @Autowired
    private CategoryDAO categoryDAO;

    @AfterEach
    public void afterEach(){
        categoryDAO = null;
    }

    @Test
    void 카테고리등록() {
        CategoryVO vo = new CategoryVO();
        vo.setCategoryName("자바");
        vo.setDisplayType("TITLE + CONTENT");
        vo.setPostCnt(5);
        vo.setDescription("자바 기록소");
        vo.setBlogName("우당탕탕 개발일지");
        categoryDAO.insertCategory(vo);
    }

    @Test
    void 카테고리수정(){
        CategoryVO vo = new CategoryVO();
        vo.setCategoryName("JAVA");
        vo.setDisplayType("TITLE");
        vo.setPostCnt(5);
        vo.setDescription("JAVA 저장소");
        vo.setSeq(1);
        categoryDAO.updateCategory(vo);
    }

    @Test
    void 카테고리삭제(){
        CategoryVO vo = new CategoryVO();
        vo.setCategoryName("JAVA");
        categoryDAO.deleteCategory(vo);
    }

    @Test
    void 카테고리전체목록조회(){
        CategoryVO vo = new CategoryVO();

        List<CategoryVO> categoryList = categoryDAO.getCategoryList(vo);
        for (CategoryVO category : categoryList) {
            System.out.println("---> " + category.toString());
        }
    }
}
