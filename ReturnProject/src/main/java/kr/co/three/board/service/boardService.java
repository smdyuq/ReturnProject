package kr.co.three.board.service;

import kr.co.three.board.dto.boardDTO;

public interface boardService {

	// 전체 게시글 수 구하기
	int selectListCount(boardDTO board);

	int enrollBoard(boardDTO board);
}
