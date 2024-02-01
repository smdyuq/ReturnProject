package kr.co.three.reply.service;

import java.util.List;

import kr.co.three.reply.dto.ReplyDTO;

public interface ReplyService {
	
//	int replyEnroll(ReplyDTO reply);
//
//	public List<ReplyDTO> list(int ask_no);
	
	int CommentRegist(ReplyDTO reply); //댓글 등록
	List<ReplyDTO> getList(int ask_no); //목록 요청
	int commentDelete(ReplyDTO reply);	//댓글 삭제

}
