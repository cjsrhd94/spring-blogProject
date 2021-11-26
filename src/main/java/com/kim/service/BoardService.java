package com.kim.service;

import com.kim.domain.BoardVO;
import com.kim.domain.CategoryVO;

import java.util.List;
import java.util.Map;

public interface BoardService {

    // 글 등록
    void insertBoard(BoardVO vo);

    // 글 수정
    void updateBoard(BoardVO vo);

    // 글 삭제
    void deleteBoard(BoardVO vo);

    // 글 상세 조회
    BoardVO getBoard(BoardVO vo);

    // 메인 페이지 글 목록 검색
    List<Map> getBoardInfo(CategoryVO categoryVO);
}
