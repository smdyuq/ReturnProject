package kr.co.three.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.co.three.board.dto.boardDTO;
import kr.co.three.board.page.PageInfo;
import kr.co.three.board.page.Pagination;
import kr.co.three.board.service.boardServiceImpl;
import kr.co.three.common.Validation.DataValidation;
import kr.co.three.common.session.SessionMessage;
import kr.co.three.common.upload.UploadFile;

@Controller
@RequestMapping("/inquiry")
public class boardController {
	
	private static final String BOARD_NAME = "C:\\Users\\jaeyun\\git\\ReturnProject\\ReturnProject\\src\\main\\webapp\\resources\\uploads\\";

	@Autowired
	private SessionMessage sessionMessage;
	@Autowired
	private boardServiceImpl boardService;

	@GetMapping("/boardList.do")
	public String boardList(boardDTO board, @RequestParam(value = "cpage", defaultValue = "1") int cpage, Model model,
			HttpSession session) {

		int listCount = boardService.selectListCount(board);
		int pageLimit = 10;
		int boardLimit = 15;
		int row = listCount - (cpage - 1) * boardLimit;

		PageInfo pi = Pagination.getPage(listCount, cpage, pageLimit, boardLimit);

		List<boardDTO> list = boardService.selectListAll(pi, board);

		for (boardDTO item : list) {
			String indate = item.getASK_DATE().substring(0, 10);
			item.setASK_DATE(indate);
		}

		String msg = (String) session.getAttribute("msg");
		String status = (String) session.getAttribute("status");

		model.addAttribute("row", row);
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		model.addAttribute("msg", msg);
		model.addAttribute("status", status);

		session.setAttribute("action", "/inquiry/boardList.do");

		session.removeAttribute("msg");
		session.removeAttribute("status");

		return "admin/board/boardList";

	}

	@GetMapping("enrollForm.do")
	public String enrollForm() {
		return "admin/board/boardEnroll";
	}

	@PostMapping("enroll.do")
	public String boardEnroll(boardDTO board, MultipartFile upload, HttpSession session)
			throws IllegalStateException, IOException {

//	public ResponseEntity<?> infoEnroll(@RequestBody InfoDTO info, MultipartFile upload, HttpSession session)
//			throws IllegalStateException, IOException {
//		board.setMEMBER_NO((int) session.getAttribute("memberName"));

		boolean titleLengthCheck = DataValidation.CheckLength(board.getASK_TITLE(), 150);
		boolean titleEmptyCheck = DataValidation.emptyCheck(board.getASK_TITLE());

		if (titleLengthCheck && titleEmptyCheck) {
			if (!upload.isEmpty()) {
				UploadFile.uploadMethod(upload, board, session, BOARD_NAME);
			}

			int result = boardService.enrollBoard(board);

			if (result > 0) {
				return "redirect:/inquiry/boardList.do";
//				return new ResponseEntity<>("success", HttpStatus.OK);
			} else {
			return "common/errorPage";
//				return new ResponseEntity<>("failed", HttpStatus.OK);
			}

			} else if(!titleLengthCheck) {
			return sessionMessage.setSessionMessage("제목이 너무 깁니다.", "error", "/free/list.do", session);
		} else if(!titleEmptyCheck) {
			return sessionMessage.setSessionMessage("제목을 입력해주세요.", "error", "/free/list.do", session);
		} else {
			return sessionMessage.setSessionMessage("에러가 발생했습니다.", "error", "/free/list.do", session);
		}
	}
}
