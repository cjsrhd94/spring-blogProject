package com.kim.persistence;

import com.kim.domain.UserVO;

public interface UserDAO {

    // ํ์ ์กฐํ
    UserVO getUser(UserVO vo);

}
