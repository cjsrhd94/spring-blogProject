package com.kim.persistence;

import com.kim.domain.BlogVO;
import com.kim.domain.UserVO;

import java.util.List;
import java.util.Map;

public interface BlogDAO {
    // 블로그 등록
    void insertBlog(BlogVO vo);

    // 블로그 수정
    void updateBlog(BlogVO vo);

    // 블로그 삭제 요청
    void requestDeleteBlog(BlogVO vo);

    // 블로그 삭제
    void deleteBlog(BlogVO vo);

    // 블로그 소유 여부 확인
    BlogVO getUserBlog(UserVO vo);

    // 특정 블로그 목록 조회
    BlogVO getBlog(BlogVO vo);

    // 메인페이지 블로그 정보 조회
    List<Map> getBlogInfo(BlogVO vo);
}
