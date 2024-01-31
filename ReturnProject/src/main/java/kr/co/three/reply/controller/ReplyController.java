package kr.co.three.reply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.three.reply.dto.ReplyDTO;
import kr.co.three.reply.service.ReplyServiceImpl;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Inject
	private ReplyServiceImpl replyService;

	@PostMapping("/InsertComment")
	public String InsertComment(@RequestBody ReplyDTO replyDto, HttpSession session) {
		int memberNo = (int)session.getAttribute("memberNo");
		
		
		System.out.println("댓글 등록 통신 성공");

		String memberType = (String) session.getAttribute("memberType");
		if (!memberType.equals("0")) {
			return "fail";
		} else {
			System.out.println("로그인함. 스크랩 진행");

			replyService.CommentRegist(replyDto);
			System.out.println("댓글 등록 서비스 성공");
			return "InsertSuccess";
		}
	}

	@GetMapping("/CommentList/{ask_no}")
	public Map<String, Object> getList(@PathVariable int ask_no) {
		List<ReplyDTO> list = replyService.getList(ask_no);

		Map<String, Object> map = new HashMap<>();
		map.put("list", list);

		return map;
	}
}