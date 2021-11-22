package com.kim.persistence;

import com.kim.domain.UserVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserVO> {

    @Override
    public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserVO user = new UserVO();
        user.setUserName(rs.getString("USERNAME"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setUserNickname(rs.getString("USERNICKNAME"));
        user.setRole(rs.getString("ROLE"));
        return user;
    }
}
