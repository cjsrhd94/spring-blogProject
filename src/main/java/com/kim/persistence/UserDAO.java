package com.kim.persistence;

import com.kim.domain.UserVO;

public interface UserDAO {

    // 회원 조회
    UserVO getUser(UserVO vo);

}
