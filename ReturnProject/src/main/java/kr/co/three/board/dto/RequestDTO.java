package kr.co.three.board.dto;

import kr.co.three.member.dto.MemberDTO;
import kr.co.three.reply.dto.ReplyDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {

	private boardDTO board;
	private ReplyDTO reply;
	private MemberDTO member;
}
