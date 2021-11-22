package com.kim.persistence;

import com.kim.domain.BlogVO;
import com.kim.domain.UserVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogRowMapper implements RowMapper<BlogVO> {

    @Override
    public BlogVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        BlogVO blog = new BlogVO();
        blog.setBlogName(rs.getString("BLOGNAME"));
        blog.setTag(rs.getString("TAG"));
        blog.setStatus(rs.getBoolean("STATUS"));
        blog.setUserName(rs.getString("USERNAME"));
        return blog;
    }
}
