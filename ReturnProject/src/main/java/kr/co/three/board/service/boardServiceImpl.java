package kr.co.three.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.three.board.dao.boardDAO;
import kr.co.three.board.dto.boardDTO;
import kr.co.three.common.PageInfo;

@Service
public class boardServiceImpl implements boardService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired 
	private boardDAO boardDao;

	public List<boardDTO> selectListAll(PageInfo pi, boardDTO board) {
		return boardDao.selectListAll(sqlSession, pi, board);

	}
	@Override
	public int selectListCount(boardDTO board) {
		return boardDao.selectListCount(sqlSession, board);
	}
	@Override
	public int enrollBoard(boardDTO board) {
		return boardDao.enrollBoard(sqlSession, board);
	}
	public boardDTO detailBoard(int ask_no) {
		return boardDao.detailBoard(sqlSession,ask_no);
	}
	@Override
	public int selectCommentCount(boardDTO board) {
		return boardDao.selectCommentCount(sqlSession, board);
	}
	
	//memberNo에 따른 게시글 조회
	@Override
	public int selectListCountByMemberNo(int memberNo) {
		return boardDao.selectListCountByMemberNo(sqlSession, memberNo);
	}
	//memberNo에 따른 게시글 리스트 작성
	@Override
	public List<boardDTO> selectListByMemberNo(PageInfo pi, int memberNo) {
		return boardDao.selectListByMemberNo(sqlSession,pi,memberNo);
	}

}
