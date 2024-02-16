package kr.co.three.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.three.board.dto.boardDTO;
import kr.co.three.board.service.boardServiceImpl;
import kr.co.three.common.PageInfo;
import kr.co.three.common.Pagination;
import kr.co.three.member.dto.MemberDTO;
import kr.co.three.member.service.MemberServiceImpl;
import kr.co.three.reply.dto.ReplyDTO;
import kr.co.three.reply.service.ReplyServiceImpl;

@Controller
@RequestMapping("/inquiry")
public class boardController {

//	private static final String BOARD_NAME = "C:\\Users\\jaeyun\\git\\ReturnProject\\ReturnProject\\src\\main\\webapp\\resources\\uploads\\";

//	@Autowired
//	private SessionMessage sessionMessage;
	@Autowired
	private boardServiceImpl boardService;
	@Autowired
	private ReplyServiceImpl replyService;
//	@Autowired
//	private MemberServiceImpl memberService;

	@GetMapping("/boardList.do")
	public ResponseEntity<?> boardList(boardDTO board, @RequestParam(value = "cpage", defaultValue = "1") int cpage,
			ReplyDTO reply, MemberDTO member, Model model, HttpSession session) {
//		public String boardList(boardDTO board, @RequestParam(value = "cpage", defaultValue = "1") int cpage,
//				ReplyDTO reply, MemberDTO member, Model model, HttpSession session) {
		// 세션에서 로그인한 사용자의 정보를 가져옵니다.
		int memberType = (int)session.getAttribute("memberType");
		int memberNo = (int)session.getAttribute("memberNo");
		
//		MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser");
//
//		System.out.println("login :" + loginUser);
//		System.out.println("memberType :" + loginUser.getMemberType());

		int listCount;
		List<boardDTO> list;

		int pageLimit = 10;
		int boardLimit = 15;

		if (memberType == 0) {
			// memberType이 0이면 모든 게시글을 가져옵니다.
			listCount = boardService.selectListCount(board);
		} else if (memberType == 1) {
			// memberType이 1이면 해당 사용자가 작성한 게시글만 가져옵니다.
			listCount = boardService.selectListCountByMemberNo(memberNo);
		} else {
			// memberType이 0이나 1이 아닌 다른 값이면 리스트가 비어있음을 나타냅니다.
			listCount = 0;
		}

		int row = listCount - (cpage - 1) * boardLimit;
		PageInfo pi = Pagination.getPageInfo(listCount, cpage, pageLimit, boardLimit);

		if (memberType == 0) {
			list = boardService.selectListAll(pi, board);
		} else if (memberType == 1) {
			list = boardService.selectListByMemberNo(pi, memberType);
		} else {
			list = new ArrayList<>();
		}

		Map<String, Object> response = new HashMap<>();
		
		for (boardDTO boardDto : list) {
			int commentCount = boardService.selectCommentCount(boardDto);
			boardDto.setCommentCount(commentCount);
			response.put("commentCount", commentCount);
//			model.addAttribute("commentCount", commentCount);
		}

		String msg = (String) session.getAttribute("msg");
		String status = (String) session.getAttribute("status");

		response.put("row", row);
		response.put("list", list);
		response.put("pi", pi);
		response.put("msg", msg);
		response.put("status", status);
		response.put("listCount", listCount);
//		model.addAttribute("row", row);
//		model.addAttribute("list", list);
//		model.addAttribute("pi", pi);
//		model.addAttribute("msg", msg);
//		model.addAttribute("status", status);
//		model.addAttribute("listCount", listCount);

//		session.setAttribute("action", "/inquiry/boardList.do");
//
//		session.removeAttribute("msg");
//		session.removeAttribute("status");

		return new ResponseEntity<>(response, HttpStatus.OK);
//		return "admin/board/boardList";
	}

//	@GetMapping("enrollForm.do")
//	public String enrollForm() {
//		return "admin/board/boardEnroll";
//	}

	@PostMapping("enroll.do")
	public ResponseEntity<?> boardEnroll(boardDTO board, MultipartFile upload, HttpSession session)
			throws IllegalStateException, IOException {
//		public String boardEnroll(boardDTO board, MultipartFile upload, HttpSession session)
//				throws IllegalStateException, IOException {

		int memberNo = (int) session.getAttribute("memberNo");
		board.setMember_no(memberNo);
		board.setAsk_image_name("임시 이미지 이름");
		board.setAsk_image_path("임시 이미지 경로");
//		System.out.println("asd : " + board.getAsk_title());

		int result = boardService.enrollBoard(board);

		if (result > 0) {
			return new ResponseEntity<>("success", HttpStatus.OK);
//			return "redirect:/inquiry/boardList.do";
		} else {
			return new ResponseEntity<>("failed", HttpStatus.OK);
//			return "common/errorPage";
		}

	}

	@GetMapping("/detail.do")
	public ResponseEntity<?> detailBoard(@RequestParam("ask_no") int askNo) {
//	public String detailBoard(@RequestParam("ask_no") int askNo, Model model,HttpSession session) {
		boardDTO board = boardService.detailBoard(askNo);
		List<ReplyDTO> replyList = replyService.getList(askNo);
//		System.out.println(list);
		
		//댓글 memberType 사용
//		int memberType = (int)session.getAttribute("memberType");

		Map<String, Object> response = new HashMap<>();
		
		if (board != null) {
			response.put("board", board);
			response.put("replyList", replyList);
			return new ResponseEntity<>(response, HttpStatus.OK);  // 상세 정보를 보여줄 뷰의 이름입니다.
//			model.addAttribute("board", board);
//			model.addAttribute("list", list);
//			return "admin/board/boardDetail"; // 상세 정보를 보여줄 뷰의 이름입니다.
		} else {
			// 게시글을 찾을 수 없는 경우, 에러 메시지를 설정하고 에러 페이지로 이동할 수 있도록 처리합니다.
//			response.put("errorMessage", "요청하신 게시글을 찾을 수 없습니다.");
			return new ResponseEntity<>("error", HttpStatus.OK); 
//			model.addAttribute("errorMessage", "요청하신 게시글을 찾을 수 없습니다.");
//			return "error"; // 에러 페이지의 뷰 이름입니다.
		}

	}
}
