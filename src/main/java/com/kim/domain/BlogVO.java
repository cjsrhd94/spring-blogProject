package com.kim.domain;

import lombok.Data;

@Data
public class BlogVO {

    /* PK = blogId
     * FK = userId
     *
     * blogId : 블로그 고유 번호
     * blogName : 블로그 이름
     * tag : 블로그 태그
     * cntDisplayPost :
     * status : 운영 상태
     * userId : 유저 고유 번호
     */

    private Long blogId;
    private String blogName;
    private String tag = "#태그";
    private Long cntDisplayPost;
    private String status = "OPEN";
    private Long userId;

}
