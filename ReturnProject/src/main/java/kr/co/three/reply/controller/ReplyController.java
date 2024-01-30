package kr.co.three.reply.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.three.reply.service.ReplyServiceImpl;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Inject
	private ReplyServiceImpl replyService;
	
	@RequestMapping(value = "enroll", method = RequestMethod.POST)
	public String replyEnroll(ReplyDTO replyDto) throws	Exception{
		replyService.write(replyDto);
		
		return "redirect:/admin/board/boardDetail.do?ask_no="+ReplyDto.getASK_NO();
	}
}
