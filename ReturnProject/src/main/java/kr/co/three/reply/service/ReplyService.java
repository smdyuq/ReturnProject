package kr.co.three.reply.service;

import java.util.List;

import kr.co.three.reply.dto.ReplyDTO;

public interface ReplyService {

	// 댓글 등록
	int CommentRegist(ReplyDTO reply); 

	// 목록 요청
	List<ReplyDTO> getList(int ask_no); 

}
