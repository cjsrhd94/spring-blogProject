package com.kim.domain;

import lombok.Data;

@Data
public class UserVO {

    /* PK = userId
     *
     * userId : 사용자 고유번호
     * id : ID
     * password : 비밀번호
     * userName : 닉네임
     * role : 권한
     */

    private Long userId;
    private String id;
    private String password;
    private String userName;
    private String role;
}
