package com.kim.persistence;

import com.kim.domain.BlogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogDAOJDBC implements BlogDAO {

    @Autowired
    private JdbcTemplate spring;

    private final String BLOG_INSERT = "insert into blog(blogname, tag, status, username) values (?, ?, ?, ?)";
    private final String BLOG_UPDATE = "update blog set blogname = ?, tag = ? where username = ?";
    private final String BLOG_DELETE = "delete blog where blogname = ?";
    private final String BLOG_GET = "select * from blog where blogname = ?";
    private final String BLOG_LIST = "select * from blog order by blogname desc";

    // 블로그 등록
    @Override
    public void insertBlog(BlogVO vo) {
        System.out.println("===> SPRING 기반으로 insertBlog() 기능 처리");
        spring.update(BLOG_INSERT, vo.getBlogName(), vo.getTag(), vo.isStatus(), vo.getUserName());
    }

    // 블로그 수정
    @Override
    public void updateBlog(BlogVO vo) {
        System.out.println("===> SPRING 기반으로 updateBlog() 기능 처리");
        spring.update(BLOG_UPDATE, vo.getBlogName(), vo.getTag(), vo.getUserName());
    }

    // 블로그 삭제
    @Override
    public void deleteBlog(BlogVO vo) {
        System.out.println("===> SPRING 기반으로 deleteBlog() 기능 처리");
        spring.update(BLOG_DELETE, vo.getBlogName());
    }

    // 특정 블로그 목록 조회
    @Override
    public BlogVO getBlog(BlogVO vo) {
        System.out.println("===> SPRING 기반으로 getBlog() 기능 처리");
        Object[] params = {vo.getBlogName()};
        return spring.queryForObject(BLOG_GET, params, new BlogRowMapper());
    }

    // 블로그 전체 목록 조회
    @Override
    public List<BlogVO> getBlogList(BlogVO vo) {
        System.out.println("===> SPRING 기반으로 getBlogList() 기능 처리");
        return spring.query(BLOG_LIST, new BlogRowMapper());
    }
}
