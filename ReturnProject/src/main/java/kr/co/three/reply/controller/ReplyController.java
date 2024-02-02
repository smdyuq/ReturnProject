package kr.co.three.reply.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.three.reply.dto.ReplyDTO;
import kr.co.three.reply.service.ReplyServiceImpl;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Inject
	private ReplyServiceImpl replyService;

	
	//댓글 등록
	@PostMapping("/InsertComment")
	@ResponseBody
	public String InsertComment(@RequestBody ReplyDTO reply, HttpSession session) {
		int memberNo = (int)session.getAttribute("memberNo");
		reply.setMember_no(memberNo);

//		replyDto.setMember_no(52);
		System.out.println("댓글 등록 통신 성공");

		String memberType = (String) session.getAttribute("memberType");
		if (!memberType.equals("0")) {
			return "fail";
		} else {
			System.out.println("로그인함. 스크랩 진행");

			replyService.CommentRegist(reply);
			
			
			System.out.println("댓글 등록 서비스 성공");
			return "InsertSuccess";
		}
	}

//	//댓글 리스트 불러오기
//	@GetMapping("/CommentList/{ask_no}")
//	public Map<String, Object> getList(@PathVariable int ask_no) {
//		List<ReplyDTO> list = replyService.getList(ask_no);
//		System.out.println(list);
//
//		Map<String, Object> map = new HashMap<>();
//		map.put("list", list);
//
//		return map;
//	}
}