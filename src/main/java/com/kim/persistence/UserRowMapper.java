package com.kim.persistence;

import com.kim.domain.UserVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {

    @Override
    public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserVO user = new UserVO();
        user.setUserId(rs.getLong("USER_ID"));
        user.setId(rs.getString("ID"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setUserName(rs.getString("USER_NAME"));
        user.setRole(rs.getString("ROLE"));
        return user;
    }
}
