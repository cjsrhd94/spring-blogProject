package com.kim.service;

import com.kim.domain.UserVO;

import java.util.List;

public interface UserService {
    // 회원 가입
    void insertUser(UserVO vo);

    // 로그인
    UserVO login(UserVO vo);

    // 회원 목록 조회
    List<UserVO> getUserList(UserVO vo);
}
