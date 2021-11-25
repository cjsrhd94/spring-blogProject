package com.kim.persistence;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BlogInfoRowMapper implements RowMapper<Map> {
    @Override
    public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
        HashMap<String, String> blogInfo = new HashMap<>();
        blogInfo.put("USER_NAME", rs.getString("USER_NAME"));
        blogInfo.put("BLOG_ID", rs.getString("BLOG_ID"));
        blogInfo.put("BLOG_NAME", rs.getString("BLOG_NAME"));
        blogInfo.put("TAG", rs.getString("TAG"));
        blogInfo.put("STATUS", rs.getString("STATUS"));
        blogInfo.put("USER_ID", rs.getString("USER_ID"));
        return blogInfo;
    }
}
