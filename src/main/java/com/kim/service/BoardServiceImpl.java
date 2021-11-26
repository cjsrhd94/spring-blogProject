package com.kim.service;

import com.kim.domain.BoardVO;
import com.kim.domain.CategoryVO;
import com.kim.persistence.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;

    // 글 등록
    @Override
    public void insertBoard(BoardVO vo) {
        boardDAO.insertBoard(vo);
    }

    // 글 수정
    @Override
    public void updateBoard(BoardVO vo) {
        boardDAO.updateBoard(vo);
    }

    // 글 삭제
    @Override
    public void deleteBoard(BoardVO vo) {
        boardDAO.deleteBoard(vo);
    }

    // 글 상세 조회
    @Override
    public BoardVO getBoard(BoardVO vo) {
        return boardDAO.getBoard(vo);
    }

    // 메인 페이지 글 목록 검색
    @Override
    public List<Map> getBoardInfo(CategoryVO categoryVO) {
        return boardDAO.getBoardInfo(categoryVO);
    }
}
