package com.kim.persistence;

import com.kim.domain.BlogVO;
import com.kim.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BlogDAOJDBC implements BlogDAO {

    @Autowired
    private JdbcTemplate spring;

    private final String BLOG_INSERT = "insert into blog(blog_Id, blog_name, tag, cnt_Display_Post, status, user_Id) " +
                                       "values (?, ?, ?, ?, ?, ?)";
    private final String BLOG_UPDATE = "update blog set blog_name = ?, tag = ?, cnt_Display_Post = ?, status = ? where blog_Id = ?";
    private final String BLOG_REQUEST_DELETE = "update blog set status = '삭제 요청' where blog_id = ?";
    private final String BLOG_DELETE = "delete blog where blog_Id = ?";
    private final String BLOG_GET = "select * from blog where blog_Id = ?";
    private final String BLOG_CHECKER = "select b.blog_id, b.blog_name, b.tag, b.cnt_display_post, b.status, b.user_ID " +
                                        "from blog as b join users as u " +
                                        "on b.user_id = u.user_id " +
                                        "where u.user_id like ?";
    private final String BLOG_LIST_FULL = "select b.BLOG_ID, b.BLOG_NAME, b.TAG, b.STATUS, b.USER_ID, u.USER_NAME from blog as b join users as u on b.user_id = u.user_id order by blog_id";
    private final String BLOG_LIST_BLOGNAME = "select b.BLOG_ID, b.BLOG_NAME, b.TAG, b.STATUS, b.USER_ID, u.USER_NAME " +
                                              "from blog as b join users as u on b.user_id = u.user_id " +
                                              "where b.BLOG_NAME like ? order by blog_Id desc";
    private final String BLOG_LIST_TAG = "select b.BLOG_ID, b.BLOG_NAME, b.TAG, b.STATUS, b.USER_ID, u.USER_NAME " +
                                         "from blog as b join users as u on b.user_id = u.user_id " +
                                         "where tag like ? order by blog_Id desc";
    private final String BLOG_LIST_USERNAME = "select b.BLOG_ID, b.BLOG_NAME, b.TAG, b.STATUS, b.USER_ID, u.USER_NAME " +
                                              "from blog as b join users as u on b.user_id = u.user_id  " +
                                              "where u.user_name like ? order by blog_id";

    // 블로그 등록
    @Override
    public void insertBlog(BlogVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 insertBlog() 기능 처리");
        spring.update(BLOG_INSERT, vo.getBlogId(), vo.getBlogName(), vo.getTag(), vo.getCntDisplayPost(), vo.getStatus(), vo.getBlogId());
    }

    // 블로그 수정
    @Override
    public void updateBlog(BlogVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 updateBlog() 기능 처리");
        spring.update(BLOG_UPDATE, vo.getBlogName(), vo.getTag(), vo.getCntDisplayPost(), vo.getStatus(), vo.getBlogId());
    }

    // 블로그 삭제 요청
    @Override
    public void requestDeleteBlog(BlogVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 requestDeleteBlog 기능 처리");
        spring.update(BLOG_REQUEST_DELETE, vo.getBlogId());
    }

    // 블로그 삭제
    @Override
    public void deleteBlog(BlogVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 deleteBlog() 기능 처리");
        spring.update(BLOG_DELETE, vo.getBlogId());
    }

    // 블로그 상세 목록 조회
    @Override
    public BlogVO getBlog(BlogVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 getBlog() 기능 처리");
        Object[] params = {vo.getBlogId()};
        try {
            return spring.queryForObject(BLOG_GET, params, new BlogRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // 블로그 소유 여부 확인
    @Override
    public BlogVO getUserBlog(UserVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 getUserBlog() 기능 처리");
        Object[] params = {vo.getUserId()};
        try {
            return spring.queryForObject(BLOG_CHECKER, params, new BlogRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // 메인 페이지 블로그 정보 조회
    @Override
    public List<Map> getBlogInfo(BlogVO vo) {
        System.out.println("===> SPRING JDBC 기반으로 getBlogInfo() 기능 처리");
        if(!vo.getSearchKeyword().isBlank()) {
            Object[] params = {"%" + vo.getSearchKeyword() + "%"};
            if (vo.getSearchCondition().equals("blogName")) {
                return spring.query(BLOG_LIST_BLOGNAME, params, new BlogInfoRowMapper());
            } else if (vo.getSearchCondition().equals("tag")) {
                return spring.query(BLOG_LIST_TAG, params, new BlogInfoRowMapper());
            } else if (vo.getSearchCondition().equals("userName")) {
                return spring.query(BLOG_LIST_USERNAME, params, new BlogInfoRowMapper());
            }
        } else {
            return spring.query(BLOG_LIST_FULL, new BlogInfoRowMapper());
        }
        return null;
    }
}

