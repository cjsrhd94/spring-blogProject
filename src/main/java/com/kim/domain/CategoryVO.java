package com.kim.domain;

import lombok.Data;

@Data
public class CategoryVO {

    /* PK = categoryName
     * FK = blogName
     *
     * blogName : 블로그 이름
     * categoryName : 카테고리 이름
     * displayType : 보이기 유형
     * postCnt : 포스트 수
     * description : 카테고리 설명
     */

    private int seq;
    private String blogName;
    private String categoryName;
    private String displayType;
    private int postCnt;
    private String description;
}
