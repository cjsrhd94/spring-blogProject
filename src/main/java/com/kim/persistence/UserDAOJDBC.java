package com.kim.persistence;

import com.kim.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOJDBC implements UserDAO {

    @Autowired
    private JdbcTemplate spring;

    private final String USER_GET = "select * from users where id = ? and password = ?";

    // 로그인
    @Override
    public UserVO getUser(UserVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 getUser() 기능 처리");
        Object[] params = {vo.getId(), vo.getPassword()};
        try {
            return (UserVO) spring.queryForObject(USER_GET, params, new UserRowMapper());
        }catch (EmptyResultDataAccessException e){
            System.out.println("===> null");
            return null;
        }
    }

}
