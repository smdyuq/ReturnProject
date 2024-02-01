package kr.co.three.board.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.board.dto.boardDTO;
import kr.co.three.common.PageInfo;

@Repository
public class boardDAO {

	public int selectListCount(SqlSessionTemplate sqlSession, boardDTO board) {
		return sqlSession.selectOne("boardMapper.selectListCount", board);
	}

	public List<boardDTO> selectListAll(SqlSessionTemplate sqlSession, PageInfo pi, boardDTO board) {
		int offset = (pi.getCpage()-1) * pi.getBoardLimit();
		RowBounds rb = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("boardMapper.selectListAll", board, rb);
	}

	public int enrollBoard(SqlSessionTemplate sqlSession, boardDTO board) {
		return sqlSession.insert("boardMapper.enrollBoard", board);
	}

	public boardDTO detailBoard(SqlSessionTemplate sqlSession, int ask_no) {
		return sqlSession.selectOne("boardMapper.detailBoard", ask_no);
	}

}
