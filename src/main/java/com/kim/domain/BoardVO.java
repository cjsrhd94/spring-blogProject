package com.kim.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {

    /* PK = seq
     * FK = categoryName
     *
     * seq : 글 순번
     * title : 글 제목
     * content : 글 내용
     * regDate : 글 등록일
     * categoryName : 카테고리 이름
     *
     */

    private int seq;
    private String title;
    private String content;
    private Date regDate;
    private String categoryName;
}
