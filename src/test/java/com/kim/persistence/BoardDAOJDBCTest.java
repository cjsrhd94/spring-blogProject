package com.kim.persistence;

import com.kim.domain.BoardVO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BoardDAOJDBCTest {
    
    @Autowired
    private BoardDAO boardDAO;

    @AfterEach
    public void afterEach(){
        boardDAO = null;
    }

    @Test
    void 글등록() {
        BoardVO vo = new BoardVO();
        vo.setTitle("블로그 첫 게시글입니다.");
        vo.setContent("와 첫 게시글!");
        vo.setCategoryName("JAVA");
        boardDAO.insertBoard(vo);
    }

    @Test
    void 글수정(){
        BoardVO vo = new BoardVO();
        vo.setTitle("수정된 첫 번째 글");
        vo.setContent("수정되었습니다");
        vo.setCategoryName("JAVA");
        vo.setSeq(1);
        boardDAO.updateBoard(vo);
    }

    @Test
    void 글삭제(){
        BoardVO vo = new BoardVO();
        vo.setSeq(2);
        boardDAO.deleteBoard(vo);
    }

    @Test
    void 글상세조회(){
        BoardVO vo = new BoardVO();
        vo.setSeq(1);
        System.out.println(boardDAO.getBoard(vo));
    }

    @Test
    void 글목록조회(){
        BoardVO vo = new BoardVO();

        List<BoardVO> boardList = boardDAO.getBoardList(vo);
        for (BoardVO board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }
}
