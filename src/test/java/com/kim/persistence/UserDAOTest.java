package com.kim.persistence;

import com.kim.domain.UserVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @AfterEach
    public void afterEach(){
        userDAO = null;
    }

    @Test
    void 회원가입() {
        UserVO vo = new UserVO();
        vo.setUserName("cjsrhd94");
        vo.setPassword("1234");
        vo.setUserNickname("김광현");
        vo.setRole("ADMIN");
        userDAO.insertUser(vo);
    }

    @Test
    void 로그인(){
        UserVO vo = new UserVO();
        vo.setUserName("cjsrhd94");
        vo.setPassword("1234");
        userDAO.getUser(vo);
    }

    @Test
    void 회원목록조회(){
        UserVO vo = new UserVO();

        List<UserVO> userList = userDAO.getUserList(vo);
        for (UserVO user : userList) {
            System.out.println("---> " + user.toString());
        }
    }
}
