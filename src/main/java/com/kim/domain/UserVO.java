package com.kim.domain;

import lombok.Data;

@Data
public class UserVO {

    /* PK = userName
     *
     * userName : ID
     * password : 비밀번호
     * userNickname : 닉네임
     * role : 권한
     *
     */

    private String userName;
    private String password;
    private String userNickname;
    private Role role;
}
