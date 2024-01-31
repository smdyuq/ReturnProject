package kr.co.three.reply.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.three.reply.dto.ReplyDTO;
import kr.co.three.reply.service.ReplyServiceImpl;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Inject
	private ReplyServiceImpl replyService;
	
	
	@PostMapping(value="addReply", produces = "application/json; charset=utf-8")
	public int replyEnroll(@RequestBody Map<String, Object> map, HttpSession session){

		ReplyDTO dto = new ReplyDTO();
		dto.setAsk_no( Integer.parseInt((String)map.get("Ask_no")) ); //원글에 대한 그룹번호를 원글번호와 맞추자
		dto.setAsk_comment_content((String)map.get("replyContent"));

		return replyService.replyEnroll(dto);

	}
}
