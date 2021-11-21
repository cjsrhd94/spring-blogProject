package com.kim.domain;

import lombok.Data;

@Data
public class BlogVO {

    /* PK = blogName
     * FK = userName
     *
     * blogName : 블로그 이름
     * tag : 블로그 태그
     * userName : ID
     */


    private String blogName;
    private String tag;
    private Status status;
    private String userName;

//    private String mainPagePost;
//    private String logo;
}
