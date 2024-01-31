package kr.co.three.board.service;

import java.util.List;

import kr.co.three.board.dto.boardDTO;
import kr.co.three.board.page.PageInfo;

public interface boardService {
	// 전체 게시글 수 구하기
	int selectListCount(boardDTO board);

	int enrollBoard(boardDTO board);
	// 게시글 상세보기
	boardDTO detailBoard(int idx);
	// 목록 불러오기
	List<boardDTO> selectListAll(PageInfo pi, boardDTO board);
}
