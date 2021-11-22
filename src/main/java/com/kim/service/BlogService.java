package com.kim.service;

import com.kim.domain.BlogVO;

import java.util.List;

public interface BlogService {

    // 블로그 등록
    void insertBlog(BlogVO vo);

    // 블로그 수정
    void updateBlog(BlogVO vo);

    // 블로그 삭제
    void deleteBlog(BlogVO vo);

    // 특정 블로그 목록 조회
    BlogVO getBlog(BlogVO vo);

    // 블로그 전체 목록 조회
    List<BlogVO> getBlogList(BlogVO vo);
}
