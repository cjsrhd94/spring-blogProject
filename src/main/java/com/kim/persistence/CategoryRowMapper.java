package com.kim.persistence;

import com.kim.domain.CategoryVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<CategoryVO> {

    @Override
    public CategoryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        CategoryVO category = new CategoryVO();
        category.setCategoryId(rs.getLong("CATEGORY_ID"));
        category.setCategoryName(rs.getString("CATEGORY_NAME"));
        category.setDisplayType(rs.getString("DISPLAY_TYPE"));
        category.setCntDisplayPost(rs.getLong("CNT_DISPLAY_POST"));
        category.setDescription(rs.getString("DESCRIPTION"));
        category.setBlogId(rs.getLong("BLOG_ID"));
        return category;
    }
}
