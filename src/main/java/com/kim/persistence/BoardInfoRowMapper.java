package com.kim.persistence;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BoardInfoRowMapper implements RowMapper<Map> {

    @Override
    public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
        HashMap<String, String> BoardInfo = new HashMap<>();
        BoardInfo.put("POST_ID", rs.getString("POST_ID"));
        BoardInfo.put("TITLE", rs.getString("TITLE"));
        BoardInfo.put("CONTENT", rs.getString("CONTENT"));
        BoardInfo.put("CREATED_DATE", rs.getString("CREATED_DATE"));
        BoardInfo.put("CATEGORY_ID", rs.getString("CATEGORY_ID"));
        BoardInfo.put("DISPLAY_TYPE", rs.getString("DISPLAY_TYPE"));
        return BoardInfo;
    }
}
