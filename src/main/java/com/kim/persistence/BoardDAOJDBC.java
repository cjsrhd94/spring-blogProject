package com.kim.persistence;

import com.kim.domain.BlogVO;
import com.kim.domain.BoardVO;
import com.kim.domain.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOJDBC implements BoardDAO {

    @Autowired
    private JdbcTemplate spring;

    private final String BOARD_INSERT = "insert into post(post_Id, title, content, category_Id) " +
                                        "values ((select nvl(max(post_Id), 0) + 1 from post), ?, ?, ?)";
    private final String BOARD_UPDATE = "update post set title = ?, content = ?, category_Id = ? where post_Id = ?";
    private final String BOARD_DELETE = "delete post where post_Id = ?";
    private final String BOARD_GET = "select * from post where post_Id = ?";
    private final String BOARD_LIST = "select * from post order by post_Id desc";
    private final String BOARD_INFO = "select p.post_id, p.title, p.content, p.created_date, p.category_id " +
                                             "from post as p join category as c " +
                                             "on c.category_id = p.category_id " +
                                             "where c.blog_id like ? order by p.post_id desc";
    private final String BOARD_INFO_SELECT = "select p.post_id, p.title, p.content, p.created_date, p.category_id " +
                                             "from post as p join category as c " +
                                             "on c.category_id = p.category_id " +
                                             "where c.blog_id like ? and c.category_id like ? order by p.post_id desc";

    // 글 등록
    @Override
    public void insertBoard(BoardVO vo) {
        System.out.println("===> SPRING 기반으로 insertBoard() 기능 처리");
        spring.update(BOARD_INSERT, vo.getTitle(), vo.getContent(), vo.getCategoryId());
    }

    // 글 수정
    @Override
    public void updateBoard(BoardVO vo) {
        System.out.println("===> SPRING 기반으로 updateBoard() 기능 처리");
        spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getCategoryId(), vo.getPostId());
    }

    // 글 삭제
    @Override
    public void deleteBoard(BoardVO vo) {
        System.out.println("===> SPRING 기반으로 deleteBoard() 기능 처리");
        spring.update(BOARD_DELETE, vo.getPostId());
    }

    // 글 상세 조회
    @Override
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> SPRING 기반으로 getBoard() 기능 처리");
        Object[] params = {vo.getPostId()};
        try {
            return spring.queryForObject(BOARD_GET, params, new BoardRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // 글 목록 검색
    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> SPRING 기반으로 getBoardList() 기능 처리");
        return spring.query(BOARD_LIST, new BoardRowMapper());
    }

    // 메인 페이지 글 목록 검색
    @Override
    public List<BoardVO> getBoardInfo(CategoryVO categoryVO) {
        System.out.println("===> SPRING 기반으로 getBoardInfo() 기능 처리");
        if (categoryVO.getCategoryId() == null) {
            Object[] params = {categoryVO.getBlogId()};
            return spring.query(BOARD_INFO, params, new BoardRowMapper());
        } else {
            Object[] params = {categoryVO.getBlogId(), categoryVO.getCategoryId()};
            return spring.query(BOARD_INFO_SELECT, params, new BoardRowMapper());
        }
    }
}
