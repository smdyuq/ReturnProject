package kr.co.three.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.three.board.dao.boardDAO;
import kr.co.three.board.dto.boardDTO;
import kr.co.three.board.page.PageInfo;

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

}
