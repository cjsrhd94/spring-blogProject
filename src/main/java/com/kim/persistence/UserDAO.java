package com.kim.persistence;

import com.kim.domain.UserVO;

import java.util.List;

public interface UserDAO {
    // 회원 가입
    void insertUser(UserVO vo);

    // 회원 조회
    UserVO getUser(UserVO vo);

    // 회원 목록 조회
    List<UserVO> getUserList(UserVO vo);
}
