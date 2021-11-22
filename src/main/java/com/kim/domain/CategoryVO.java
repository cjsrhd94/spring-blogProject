package com.kim.domain;

import lombok.Data;

@Data
public class CategoryVO {

    /* PK = categoryId
     * FK = blogId
     *
     * categoryId : 카테고리 고유번호
     * categoryName : 카테고리 이름
     * displayType : 보이기 유형
     * cntDisplayPost : 포스트 수
     * description : 카테고리 설명
     * blogId : 블로그 고유번호
     */

    private Long categoryId;
    private String categoryName;
    private String displayType;
    private Long cntDisplayPost;
    private String description;
    private Long blogId;
}
