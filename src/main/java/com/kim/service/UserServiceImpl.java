package com.kim.service;

import com.kim.domain.UserVO;
import com.kim.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    // 로그인
    @Override
    public UserVO login(UserVO vo) {
        return userDAO.getUser(vo);
    }

}
