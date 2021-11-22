package com.kim.persistence;

import com.kim.domain.BlogVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BlogDAOJDBCTest {

    @Autowired
    private BlogDAO blogDAO;

    @AfterEach
    public void afterEach(){
        blogDAO = null;
    }

    @Test
    void 블로그등록() {
        BlogVO vo = new BlogVO();
        vo.setBlogName("cjsrhd94의 블로그");
        vo.setUserName("cjsrhd94");
        blogDAO.insertBlog(vo);
    }

    @Test
    void 블로그수정(){
        BlogVO vo = new BlogVO();
        vo.setBlogName("우당탕탕 개발일지");
        vo.setTag("#spring, #java");
        vo.setUserName("cjsrhd94");
        blogDAO.updateBlog(vo);
    }

    @Test
    void 블로그삭제(){
        BlogVO vo = new BlogVO();
        vo.setBlogName("우당탕탕 개발일지");
        blogDAO.deleteBlog(vo);
    }

    @Test
    void 특정블로그목록조회(){
        BlogVO vo = new BlogVO();
        vo.setBlogName("우당탕탕 개발일지");
        System.out.println(blogDAO.getBlog(vo));
    }

    @Test
    void 블로그전체목록조회(){
        BlogVO vo = new BlogVO();

        List<BlogVO> blogList = blogDAO.getBlogList(vo);
        for (BlogVO blog : blogList) {
            System.out.println("---> " + blog.toString());
        }
    }
}