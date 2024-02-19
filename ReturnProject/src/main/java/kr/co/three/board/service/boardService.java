package kr.co.three.board.service;

import java.util.List;

import kr.co.three.board.dto.boardDTO;
import kr.co.three.common.PageInfo;

public interface boardService {

	// 전체 게시글 수 구하기
	int selectListCount(boardDTO board);

	// 문의 게시글 등록
	int enrollBoard(boardDTO board);

	// 게시글 상세보기
	boardDTO detailBoard(int idx);

	// 목록 불러오기
	List<boardDTO> selectListAll(PageInfo pi, boardDTO board);

	// 댓글 수 구하기
	int selectCommentCount(boardDTO board);

	// memberNo에 따른 게시글 카운트
	int selectListCountByMemberNo(int memberNo);

	// memberNo에 따른 리스트 작성
	List<boardDTO> selectListByMemberNo(PageInfo pi, int memberNo);

}
