package com.kim.persistence;

import com.kim.domain.BoardVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setContent(rs.getString("CONTENT"));				
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCategoryName(rs.getString("CATEGORYNAME"));
		return board;
	}

}
