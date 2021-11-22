package com.kim.persistence;

import com.kim.domain.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOJDBC implements CategoryDAO {

    @Autowired
    private JdbcTemplate spring;

    private final String CATEGORY_INSERT = "insert into category(seq, categoryname, displaytype, postCnt, description, blogname) " +
                                           "values ((select nvl(max(seq), 0) + 1 from board), ?, ?, ?, ?, ?)";
    private final String CATEGORY_UPDATE = "update category set categoryname = ?, displaytype = ?, postCnt = ?,description = ? where seq = ?";
    private final String CATEGORY_DELETE = "delete category where categoryname = ?";
    private final String CATEGORY_LIST = "select * from category order by seq desc";


    // 카테고리 등록
    @Override
    public void insertCategory(CategoryVO vo) {
        System.out.println("===> SPRING 기반으로 insertCategory() 기능 처리");
        spring.update(CATEGORY_INSERT, vo.getCategoryName(), vo.getDisplayType(), vo.getPostCnt(), vo.getDescription(), vo.getBlogName());
    }

    // 카테고리 수정
    @Override
    public void updateCategory(CategoryVO vo) {
        System.out.println("===> SPRING 기반으로 updateCategory() 기능 처리");
        spring.update(CATEGORY_UPDATE, vo.getCategoryName(), vo.getDisplayType(), vo.getPostCnt(), vo.getDescription(), vo.getSeq());
    }

    // 카테고리 삭제
    @Override
    public void deleteCategory(CategoryVO vo) {
        System.out.println("===> SPRING 기반으로 deleteCategory() 기능 처리");
        spring.update(CATEGORY_DELETE, vo.getCategoryName());
    }

    // 카테고리 전체 목록 조회
    @Override
    public List<CategoryVO> getCategoryList(CategoryVO vo) {
        System.out.println("===> SPRING 기반으로 getCategoryList() 기능 처리");
        return spring.query(CATEGORY_LIST, new CategoryRowMapper());
    }


}
