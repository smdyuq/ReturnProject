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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.co.three.board.dto.boardDTO;
import kr.co.three.board.service.boardServiceImpl;
import kr.co.three.common.PageInfo;
import kr.co.three.common.Pagination;
import kr.co.three.member.dto.MemberDTO;
import kr.co.three.member.service.MemberServiceImpl;
import kr.co.three.reply.dto.ReplyDTO;
import kr.co.three.reply.service.ReplyServiceImpl;

@RestController
@RequestMapping("/inquiry")
public class boardController {

   @Autowired
   private boardServiceImpl boardService;
   @Autowired
   private ReplyServiceImpl replyService;
   @Autowired
   private MemberServiceImpl memberService;

////   1:1 문의 게시판 불러오기
//   @GetMapping("/boardList.do")
//   public String boardList(boardDTO board, @RequestParam(value = "cpage", defaultValue = "1") int cpage,
//         ReplyDTO reply, MemberDTO member, Model model, HttpSession session) {
//      int memberType = (int) session.getAttribute("memberType");
//      int memberNo = (int) session.getAttribute("memberNo");
//
//      int listCount;
//      List<boardDTO> list;
//
//      int pageLimit = 10;
//      int boardLimit = 15;
//
//      if (memberType == 0) {
//         listCount = boardService.selectListCount(board);
//      } else if (memberType == 1) {
//         listCount = boardService.selectListCountByMemberNo(memberNo);
//      } else {
//         listCount = 0;
//      }
//
//      int row = listCount - (cpage - 1) * boardLimit;
//      PageInfo pi = Pagination.getPageInfo(listCount, cpage, pageLimit, boardLimit);
//
//      if (memberType == 0) {
//         list = boardService.selectListAll(pi, board);
//      } else if (memberType == 1) {
//         list = boardService.selectListByMemberNo(pi, memberType);
//      } else {
//         list = new ArrayList<>();
//      }
//
//      for (boardDTO boardDto : list) {
//         int commentCount = boardService.selectCommentCount(boardDto);
//         boardDto.setCommentCount(commentCount);
//         model.addAttribute("commentCount", commentCount);
//      }
//
//      String msg = (String) session.getAttribute("msg");
//      String status = (String) session.getAttribute("status");
//
//      model.addAttribute("row", row);
//      model.addAttribute("list", list);
//      model.addAttribute("pi", pi);
//      model.addAttribute("msg", msg);
//      model.addAttribute("status", status);
//      model.addAttribute("listCount", listCount);
//
//      session.setAttribute("action", "/inquiry/boardList.do");
//
//      session.removeAttribute("msg");
//      session.removeAttribute("status");
//
//      return "admin/board/boardList";
//   }

//   1:1 문의 게시판 불러오기
   @GetMapping("/boardList")
   public ResponseEntity<?> boardList(@RequestBody boardDTO board,
         @RequestParam(value = "cpage", defaultValue = "1") int cpage, @RequestBody ReplyDTO reply,
         @RequestBody MemberDTO member, HttpSession session) {
      int memberType = (int) session.getAttribute("memberType");
      int memberNo = (int) session.getAttribute("memberNo");

      int listCount;
      List<boardDTO> list;

      int pageLimit = 10;
      int boardLimit = 15;

      if (memberType == 0) {
         listCount = boardService.selectListCount(board);
      } else if (memberType == 1) {
         listCount = boardService.selectListCountByMemberNo(memberNo);
      } else {
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
      }

      String msg = (String) session.getAttribute("msg");
      String status = (String) session.getAttribute("status");

      response.put("row", row);
      response.put("list", list);
      response.put("pi", pi);
      response.put("msg", msg);
      response.put("status", status);
      response.put("listCount", listCount);

      session.setAttribute("action", "/inquiry/boardList.do");

      session.removeAttribute("msg");
      session.removeAttribute("status");

      return new ResponseEntity<>(response, HttpStatus.OK);
   }

////   1:1 문의 등록 폼 이동
//   @GetMapping("enrollForm.do")
//   public String enrollForm() {
//      return "admin/board/boardEnroll";
//   }

//   1:1 문의 등록
   @PostMapping("enroll")
   public ResponseEntity<?> boardEnroll(@RequestBody boardDTO board, MultipartFile upload, HttpSession session)
         throws IllegalStateException, IOException {

      int memberNo = (int) session.getAttribute("memberNo");
      board.setMember_no(memberNo);
      board.setAsk_image_name("임시 이미지 이름");
      board.setAsk_image_path("임시 이미지 경로");
      System.out.println("asd : " + board.getAsk_title());

      int result = boardService.enrollBoard(board);

      if (result > 0) {
         return new ResponseEntity<>("success", HttpStatus.OK);
      } else {
         return new ResponseEntity<>("error", HttpStatus.OK);
      }

   }

////   1:1 문의 상세보기
//   @GetMapping("/detail.do")
//   public String detailBoard(@RequestParam("ask_no") int askNo, Model model, HttpSession session) {
//      boardDTO board = boardService.detailBoard(askNo);
//      List<ReplyDTO> list = replyService.getList(askNo);
//      System.out.println(list);
//
//      int memberType = (int) session.getAttribute("memberType");
//
//      if (board != null) {
//         model.addAttribute("board", board);
//         model.addAttribute("list", list);
//         return "admin/board/boardDetail";
//      } else {
//         model.addAttribute("errorMessage", "요청하신 게시글을 찾을 수 없습니다.");
//         return "error";
//      }
//
//   }
//}

//   1:1 문의 상세보기
   @GetMapping("/detail")
   public ResponseEntity<?> detailBoard(@RequestParam("ask_no") int askNo, HttpSession session) {
      boardDTO board = boardService.detailBoard(askNo);
      List<ReplyDTO> list = replyService.getList(askNo);

      int memberType = (int) session.getAttribute("memberType");

      Map<String, Object> response = new HashMap<>();

      if (board != null) {
         response.put("board", board);
         response.put("list", list);
         return new ResponseEntity<>(response, HttpStatus.OK);
      } else {
         return new ResponseEntity<>("error", HttpStatus.OK);
      }

   }
}