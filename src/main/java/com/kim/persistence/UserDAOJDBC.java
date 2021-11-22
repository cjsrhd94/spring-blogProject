package com.kim.persistence;

import com.kim.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOJDBC implements UserDAO {

    @Autowired
    private JdbcTemplate spring;

    private final String USER_INSERT = "insert into users(userName, password, userNickname, role) values (?, ?, ?, ?)";
    private final String USER_GET = "select * from users where username = ? and password = ?";
    private final String USER_LIST = "select * from users order by username desc";

    // 회원 가입
    @Override
    public void insertUser(UserVO vo) {
        System.out.println("===> SPRING 기반으로 insertUser() 기능 처리");
        spring.update(USER_INSERT, vo.getUserName(), vo.getPassword(), vo.getUserNickname(), vo.getRole());
    }

    // 로그인
    @Override
    public UserVO getUser(UserVO vo) {
        System.out.println("===> SPRING 기반으로 getUser() 기능 처리");
        Object[] params = {vo.getUserName(), vo.getPassword()};
        return spring.queryForObject(USER_GET, params, new UserRowMapper());
    }

    // 회원 목록 조회
    @Override
    public List<UserVO> getUserList(UserVO vo) {
        System.out.println("===> SPRING 기반으로 getUserList() 기능 처리");
        return spring.query(USER_LIST, new UserRowMapper());
    }
}
