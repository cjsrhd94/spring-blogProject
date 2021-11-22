package com.kim.service;

import com.kim.domain.UserVO;
import com.kim.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    // 회원 가입
    @Override
    public void insertUser(UserVO vo) {
        userDAO.insertUser(vo);
    }

    // 로그인
    @Override
    public UserVO login(UserVO vo) {
        return userDAO.getUser(vo);
    }

    // 회원 목록 조회
    @Override
    public List<UserVO> getUserList(UserVO vo) {
        return userDAO.getUserList(vo);
    }
}
