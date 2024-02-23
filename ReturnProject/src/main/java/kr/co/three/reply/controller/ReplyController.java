package kr.co.three.reply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.three.reply.dto.ReplyDTO;
import kr.co.three.reply.service.ReplyServiceImpl;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	@Inject
	private ReplyServiceImpl replyService;

//   // 댓글 등록
//   @PostMapping("/InsertComment.do")
//   @ResponseBody
//   public String InsertComment(@RequestBody ReplyDTO reply, HttpSession session) {
//      int memberNo = (int) session.getAttribute("memberNo");
//      reply.setMember_no(memberNo);
//
//      int memberType = (int) session.getAttribute("memberType");
//      if (memberType != 0) {
//         return "fail";
//      } else {
//         System.out.println("로그인함. 스크랩 진행");
//
//         replyService.CommentRegist(reply);
//
//         System.out.println("댓글 등록 서비스 성공");
//         return "InsertSuccess";
//      }
//   }

//   댓글 등록

   @PostMapping("/insertComment")
   @ResponseBody
   public ResponseEntity<?> InsertComment(@RequestBody Map<String, Object> map) {
	   
	   System.out.println("1 :"+map);
	   
	   for( Map.Entry<String, Object> entry : map.entrySet() ){
			String strKey = entry.getKey();
			Object strValue = entry.getValue();
		    System.out.println( strKey +":"+ strValue );
		}
	   
	   int askNo = (int)(double)map.get("askNo");
	   String reply = ((Map<String, String>)map.get("reply")).get("content"); // reply에서 content 값을 가져옵니다.
	   
	    Map<String, Object> memberMap = (Map<String, Object>)map.get("member");
//	    System.out.println("a"+askNo);
	    int memberType = (int)(double)memberMap.get("memberType");
	    int memberNo = (int)(double)memberMap.get("memberNo");
//	   System.out.println("memberType+memberNo"+ memberType+"/"+memberNo);
//      int memberNo = (int) session.getAttribute("memberNo");
//      int memberNo = member.getMemberNo();
//      member.setMemberNo(memberNo);

//      int memberType = (int) session.getAttribute("memberType");
//      int memberType = member.getMemberType();
//	  int memberType = 0;
      if (memberType != 0) {
         return new ResponseEntity<>("error", HttpStatus.OK);
      } else {
//         System.out.println("로그인함. 스크랩 진행");

          ReplyDTO replyDTO = new ReplyDTO();
          replyDTO.setAsk_comment_content(reply);
          replyDTO.setMember_no(memberNo);
          replyDTO.setAsk_no(askNo);
          
          replyService.CommentRegist(replyDTO);
    	  
    	  
//         replyService.CommentRegist(new ReplyDTO());

         System.out.println("댓글 등록 서비스 성공");
         return new ResponseEntity<>("success", HttpStatus.OK);
      }
   }
	//댓글 리스트 불러오기
	@GetMapping("/CommentList/{ask_no}")
//	public ResponseEntity<?> getList(@PathVariable int ask_no) {
		public Map<String, Object> getList(@PathVariable int ask_no) {
		System.out.println("12312312");
		List<ReplyDTO> list = replyService.getList(ask_no);
		System.out.println("1 :"+ list);

		Map<String, Object> response = new HashMap<>();
		response.put("list", list);
		
		

		return response;
//		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}