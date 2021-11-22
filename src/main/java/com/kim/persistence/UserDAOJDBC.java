package com.kim.persistence;

import com.kim.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOJDBC implements UserDAO {

    @Autowired
    private JdbcTemplate spring;

    private final String USER_INSERT = "insert into users(user_id, id, password, user_name, role) " +
                                       "values ((select nvl(max(user_id), 0) + 1 from users),?, ?, ?, ?)";
    private final String USER_GET = "select * from users where id = ? and password = ?";
    private final String USER_LIST = "select * from users order by user_Id desc";

    // 회원 가입
    @Override
    public void insertUser(UserVO vo) {
        System.out.println("===> SPRING 기반으로 insertUser() 기능 처리");
        spring.update(USER_INSERT, vo.getId(), vo.getPassword(), vo.getUserName(), vo.getRole());
    }

    // 로그인
    @Override
    public UserVO getUser(UserVO vo) {
        System.out.println("===> SPRING 기반으로 getUser() 기능 처리");
        Object[] params = {vo.getId(), vo.getPassword()};
        try {
            return (UserVO) spring.queryForObject(USER_GET, params, new UserRowMapper());
        }catch (EmptyResultDataAccessException e){
            System.out.println("===> null");
            return null;
        }
    }

    // 회원 목록 조회
    @Override
    public List<UserVO> getUserList(UserVO vo) {
        System.out.println("===> SPRING 기반으로 getUserList() 기능 처리");
        return spring.query(USER_LIST, new UserRowMapper());
    }
}
