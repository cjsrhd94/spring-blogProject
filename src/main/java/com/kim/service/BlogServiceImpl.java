package com.kim.service;

import com.kim.domain.BlogVO;
import com.kim.domain.CategoryVO;
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
    public void insertBlog(BlogVO blogVO) {
        blogDAO.insertBlog(blogVO);
        categoryDAO.insertCategory_unclassified(blogVO);
    }

    @Override
    public void updateBlog(BlogVO vo) {
        blogDAO.updateBlog(vo);
    }

    @Override
    public void deleteBlog(BlogVO vo) {
        blogDAO.deleteBlog(vo);
    }

    @Override
    public BlogVO getBlog(BlogVO vo) {
        return blogDAO.getBlog(vo);
    }

    @Override
    public List<BlogVO> getBlogList(BlogVO vo) {
        return blogDAO.getBlogList(vo);
    }

    @Override
    public List<Map> getBlogInfo(BlogVO vo) {
        return blogDAO.getBlogInfo(vo);
    }

    @Override
    public BlogVO getUserBlog(UserVO vo){
        return blogDAO.getUserBlog(vo);
    }

    @Override
    public void requestDeleteBlog(BlogVO vo){
        blogDAO.requestDeleteBlog(vo);
    }
}
