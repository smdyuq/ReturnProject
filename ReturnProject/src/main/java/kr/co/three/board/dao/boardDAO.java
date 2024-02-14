package kr.co.three.board.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.board.dto.boardDTO;
import kr.co.three.common.PageInfo;

@Repository
public class boardDAO {
	//보드 게시글 수량 구하기
	public int selectListCount(SqlSessionTemplate sqlSession, boardDTO board) {
		return sqlSession.selectOne("boardMapper.selectListCount", board);
	}
	//보드 게시글 가져오기
	public List<boardDTO> selectListAll(SqlSessionTemplate sqlSession, PageInfo pi, boardDTO board) {
		int offset = (pi.getCpage()-1) * pi.getBoardLimit();
		RowBounds rb = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("boardMapper.selectListAll", board, rb);
	}
	//게시판 등록
	public int enrollBoard(SqlSessionTemplate sqlSession, boardDTO board) {
		return sqlSession.insert("boardMapper.enrollBoard", board);
	}
	//게시글 상세보기
	public boardDTO detailBoard(SqlSessionTemplate sqlSession, int ask_no) {
		return sqlSession.selectOne("boardMapper.detailBoard", ask_no);
	}
	//게시글 댓글 구하기
	public int selectCommentCount(SqlSessionTemplate sqlSession, boardDTO board) {
		return sqlSession.selectOne("boardMapper.selectCommentCount", board);
	}
	//memberType 별 게시글 불러오기
	public int selectListCountByMemberNo(SqlSessionTemplate sqlSession, int memberNo) {
		return sqlSession.selectOne("boardMapper.selectListCountByMemberNo",memberNo);
	}
	public List<boardDTO> selectListByMemberNo(SqlSessionTemplate sqlSession, PageInfo pi, int memberNo) {
		int offset = (pi.getCpage()-1) * pi.getBoardLimit();
		RowBounds rb = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("boardMapper.selectListByMemberNo", memberNo, rb);
	}

}
