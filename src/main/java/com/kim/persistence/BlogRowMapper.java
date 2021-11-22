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
        blog.setBlogId(rs.getLong("BLOG_ID"));
        blog.setBlogName(rs.getString("BLOG_NAME"));
        blog.setTag(rs.getString("TAG"));
        blog.setCntDisplayPost(rs.getLong("CNT_DISPLAY_POST"));
        blog.setStatus(rs.getString("STATUS"));
        blog.setUserId(rs.getLong("USER_ID"));
        return blog;
    }
}
