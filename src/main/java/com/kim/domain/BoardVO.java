package com.kim.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {

    /* PK = postId
     * FK = categoryName
     *
     * postId : 글 고유번호
     * title : 글 제목
     * content : 글 내용
     * createdDate : 글 등록일
     * categoryId : 카테고리 고유번호
     */

    private Long postId;
    private String title;
    private String content;
    private Date createdDate;
    private Long categoryId;
}
