package com.kim.persistence;

import com.kim.domain.CategoryVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<CategoryVO> {

    @Override
    public CategoryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        CategoryVO category = new CategoryVO();
        category.setSeq(rs.getInt("seq"));
        category.setCategoryName(rs.getString("CATEGORYNAME"));
        category.setDisplayType(rs.getString("DISPLAYTYPE"));
        category.setPostCnt(rs.getInt("POSTCNT"));
        category.setDescription(rs.getString("DESCRIPTION"));
        category.setBlogName(rs.getString("BLOGNAME"));
        return category;
    }
}
