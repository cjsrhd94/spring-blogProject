package com.kim.service;

import com.kim.domain.BlogVO;
import com.kim.domain.UserVO;
import com.kim.persistence.BlogDAO;
import com.kim.persistence.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@EnableTransactionManagement
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDAO blogDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    // 블로그 생성시 미분류 카테고리가 생성되게 트랜잭션 처리
    public void insertBlog(BlogVO blogVO) {
        blogDAO.insertBlog(blogVO);
        categoryDAO.insertCategory_unclassified(blogVO);
    }

    // 블로그 수정
    @Override
    public void updateBlog(BlogVO vo) {
        blogDAO.updateBlog(vo);
    }

    // 블로그 삭제 요청
    @Override
    public void requestDeleteBlog(BlogVO vo) {
        blogDAO.requestDeleteBlog(vo);
    }

    // 블로그 삭제
    @Override
    public void deleteBlog(BlogVO vo) {
        blogDAO.deleteBlog(vo);
    }

    // 블로그 소유 여부 확인
    @Override
    public BlogVO getUserBlog(UserVO vo) {
        return blogDAO.getUserBlog(vo);
    }

    // 특정 블로그 목록 조회
    @Override
    public BlogVO getBlog(BlogVO vo) {
        return blogDAO.getBlog(vo);
    }

    // 메인페이지 블로그 정보 조회
    @Override
    public List<Map> getBlogInfo(BlogVO vo) {
        return blogDAO.getBlogInfo(vo);
    }
}


