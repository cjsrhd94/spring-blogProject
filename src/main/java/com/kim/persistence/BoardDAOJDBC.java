package com.kim.persistence;

import com.kim.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOJDBC implements BoardDAO {

    @Autowired
    private JdbcTemplate spring;

    private final String BOARD_INSERT     = "insert into board(seq, title, content, categoryname) " +
                                            "values ((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
    private final String BOARD_UPDATE     = "update board set title = ?, content = ?, categoryname = ? where seq = ?";
    private final String BOARD_DELETE     = "delete board where seq = ?";
    private final String BOARD_GET        = "select * from board where seq = ?";
    private final String BOARD_LIST       = "select * from board order by seq desc";

    // 글 등록
    @Override
    public void insertBoard(BoardVO vo) {
        System.out.println("===> SPRING 기반으로 insertBoard() 기능 처리");
        spring.update(BOARD_INSERT, vo.getTitle(), vo.getContent(), vo.getCategoryName());
    }

    // 글 수정
    @Override
    public void updateBoard(BoardVO vo) {
        System.out.println("===> SPRING 기반으로 updateBoard() 기능 처리");
        spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getCategoryName(), vo.getSeq());
    }

    // 글 삭제
    @Override
    public void deleteBoard(BoardVO vo) {
        System.out.println("===> SPRING 기반으로 deleteBoard() 기능 처리");
        spring.update(BOARD_DELETE, vo.getSeq());
    }

    // 글 상세 조회
    @Override
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> SPRING 기반으로 getBoard() 기능 처리");
        Object[] params = {vo.getSeq()};
        return spring.queryForObject(BOARD_GET, params, new BoardRowMapper());
    }

    // 글 목록 검색
    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> SPRING 기반으로 getBoardList() 기능 처리");
        return spring.query(BOARD_LIST, new BoardRowMapper());
    }
}
