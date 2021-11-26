package com.kim.persistence;

import com.kim.domain.BlogVO;
import com.kim.domain.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOJDBC implements CategoryDAO {

    @Autowired
    private JdbcTemplate spring;

    private final String CATEGORY_INSERT = "insert into category(category_id, category_name, display_type, cnt_display_post, description, blog_id) " +
                                           "values ((select nvl(max(category_id), 0) + 1 from category), ?, ?, ?, ?, ?)";
    private final String CATEGORY_UPDATE = "update category set category_name = ?, display_type = ?, cnt_Display_Post = ?,description = ? where category_id = ?";
    private final String CATEGORY_DELETE = "delete category where category_id = ?";
    private final String CATEGORY_GET = "select * from category where category_id = ?";
    private final String CATEGORY_LIST = "select * from category where blog_id = ? order by category_id asc ";

    // 카테고리 등록
    @Override
    public void insertCategory(CategoryVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 insertCategory() 기능 처리");
        spring.update(CATEGORY_INSERT, vo.getCategoryName(), vo.getDisplayType(), vo.getCntDisplayPost(), vo.getDescription(), vo.getBlogId());
    }

    // 블로그 생성시 미분류 카테고리를 등록
    @Override
    public void insertCategory_unclassified(BlogVO blogVO) {
        System.out.println("===> SPRING JDBC 기반으로 insertCategory_unclassified 기능 처리");
        spring.update(CATEGORY_INSERT, "미분류", "제목+내용", 5, "기본 카테고리 입니다", blogVO.getBlogId());
    }

    // 카테고리 수정
    @Override
    public void updateCategory(CategoryVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 updateCategory() 기능 처리");
        spring.update(CATEGORY_UPDATE, vo.getCategoryName(), vo.getDisplayType(), vo.getCntDisplayPost(), vo.getDescription(), vo.getCategoryId());
    }

    // 카테고리 삭제
    @Override
    public void deleteCategory(CategoryVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 deleteCategory() 기능 처리");
        spring.update(CATEGORY_DELETE, vo.getCategoryId());
    }

    // 카테고리 상세 조회
    @Override
    public CategoryVO getCategory(CategoryVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 getCategory() 기능 처리");
        Object[] params = {vo.getCategoryId()};
        try {
            return spring.queryForObject(CATEGORY_GET, params, new CategoryRowMapper());
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    // 카테고리 전체 목록 조회
    @Override
    public List<CategoryVO> getCategoryList(CategoryVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 getCategoryList() 기능 처리");
        Object[] params = {vo.getBlogId()};
        return spring.query(CATEGORY_LIST, params, new CategoryRowMapper());
    }


}
