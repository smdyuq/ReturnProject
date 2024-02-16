package kr.co.three.sales.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.co.three.common.PageInfo;
import kr.co.three.common.Pagination;
import kr.co.three.common.UploadFile;
import kr.co.three.member.dto.MemberDTO;
import kr.co.three.member.service.MemberServiceImpl;
import kr.co.three.sales.dto.SalesDTO;
import kr.co.three.sales.service.SalesServiceImpl;

@RestController
@RequestMapping("/sales")
public class SalesController {

   @Autowired
   private SalesServiceImpl salesService;

   @Autowired
   private MemberServiceImpl memberService;

//   판매하기 페이지로 이동
//   @GetMapping("/enrollSalesForm.do")
//   public String enrollSalesForm() {
//      return "sales/enrollSales";
//   }

//   상품관리 페이지로 이동
   @GetMapping("manageSalesForm.do")
   public ResponseEntity<?> manageSalesForm(SalesDTO sales, @RequestParam(value = "cpage", defaultValue = "1") int cpage,
         HttpSession session) {
//   public String manageSalesForm(SalesDTO sales, @RequestParam(value = "cpage", defaultValue = "1") int cpage,
//		 Model model, HttpSession session) {

      int memberNo = (int) session.getAttribute("memberNo");
      sales.setMemberNo(memberNo);

      // 전체 게시글 수 구하기
      int listCount = salesService.salesSelectListCount(sales);
      int pageLimit = 5;
      int boardLimit = 8;

      // 게시글 번호
      // 26
      int row = listCount - (cpage - 1) * boardLimit;

      PageInfo pi = Pagination.getPageInfo(listCount, cpage, pageLimit, boardLimit);

      // 목록 불러오기
      List<SalesDTO> list = salesService.salesSelectListAll(pi, sales);

      Map<String, Object> response = new HashMap<>();
      response.put("list", list);
      response.put("pi", pi);
      response.put("row", row);
//      model.addAttribute("list", list);
//      model.addAttribute("pi", pi);
//      model.addAttribute("row", row);
      return new ResponseEntity<>(response, HttpStatus.OK);
   }

//   상품수정 페이지로 이동
   @GetMapping("updateSalesForm.do")
	public ResponseEntity<?> updateSalesForm(@RequestParam(value = "salesNo") int salesNo, Model model) {
//	   public String updateSalesForm(@RequestParam(value = "salesNo") int salesNo, Model model) {
      SalesDTO result = salesService.updateSalesForm(salesNo);

      Map<String, Object> response = new HashMap<>();
      
      response.put("sales", result);
//      model.addAttribute("sales", result);

      return new ResponseEntity<>(response, HttpStatus.OK);
//      return "sales/updateSales";
   }

// 상품 수정
 @PostMapping("updateSales.do")
 public ResponseEntity<?> updateSales(SalesDTO sales, HttpSession session, List<MultipartFile> uploads) {
//	 public String updateSales(SalesDTO sales, HttpSession session, List<MultipartFile> uploads) {

    // 판매등록 작성자 조회
    int salesMember = salesService.selectSalesMember(sales.getSalesNo()); // 판매등록 작성자

    int memberNo = (int) session.getAttribute("memberNo"); // 로그인 유저

    int result = 0;

    int imageResult = 0;
    int deleteCount = 0;
    int enrollCount = 0;
    for (MultipartFile m : uploads) {
       if (salesMember == memberNo && !m.isEmpty()) {
          UploadFile.uploadMethod(m, sales, session);

          if (deleteCount == 0) {
             // 상품 삭제
             int deleteSales = salesService.deleteUpdateSales(sales);
             deleteCount++;
          }

          if (enrollCount == 0) {
             result = salesService.enrollSales(sales);
             int salesNoSelect = salesService.salesNoSelect();
             sales.setSalesNo(salesNoSelect);
             enrollCount++;
          }
          int imageInsert = salesService.imageInsert(sales);

       } else if (salesMember == memberNo && m.isEmpty()) {
          int salesNoSelect = salesService.salesNoSelect();
          sales.setSalesNo(salesNoSelect);
          int deleteSaleStatus = salesService.deleteSaleStatus(sales);
          result = salesService.updateSales(sales);
       }
    }
    if (result == 1) {
       // 판매 번호 조회
       int selectSalesNo = salesService.selectSalesNo(memberNo);
       sales.setSalesNo(selectSalesNo);
       // 판매 상태 : 판매 중
       int statusResult = salesService.salesStatus(sales.getSalesNo());
       return new ResponseEntity<>("success", HttpStatus.OK);
//       return "redirect:/sales/manageSalesForm.do";
    } else {
    	return new ResponseEntity<>("error", HttpStatus.OK);
//       return "common/error";
    }
 }

//   상품 삭제
   @GetMapping("deleteSales.do")
   public ResponseEntity<?> deleteSales(@RequestParam(value = "salesNo") int salesNo) {
//	public String deleteSales(@RequestParam(value = "salesNo") int salesNo) {

      int result = salesService.deleteSales(salesNo);

      return new ResponseEntity<>("success", HttpStatus.OK);
//      return "redirect:/sales/manageSalesForm.do";

   }

// 상품 상세
 @GetMapping("detailSales.do")
 public ResponseEntity<?> detailSales(@RequestParam(value = "salesNo") int salesNo, SalesDTO sales, Model model,
       HttpSession session) {
//	 public String detailSales(@RequestParam(value = "salesNo") int salesNo, SalesDTO sales, Model model,
//			 HttpSession session) {

    int memberNo = 0;
    
    Map<String, Object> response = new HashMap<>();

    try {
       memberNo = (int) session.getAttribute("memberNo");
       sales.setMemberNo(memberNo);
       sales.setSalesNo(salesNo);

       // 최근 본 상품
       int recentSales = salesService.recentSales(sales);

       // 상품 상세
       SalesDTO result = salesService.detailSales(salesNo);

       // 이미지 상세
       List<String> ImageSelect = salesService.ImageSelect(salesNo);

       // 판매상품 회원번호 조회
       int selectMemberNo = salesService.selectMemberNo(sales.getSalesNo());

       // 멤버 테이블 데이터 조회
       if (memberNo == selectMemberNo) {
          MemberDTO memberResult = memberService.selectMemberData(selectMemberNo);
          response.put("member", memberResult);
//          model.addAttribute("member", memberResult);
       } else {
          MemberDTO memberResult = memberService.selectMemberData(selectMemberNo);
          response.put("member", memberResult);
//          model.addAttribute("member", memberResult);
       }

       response.put("sales", result);
       response.put("image", ImageSelect);

       return new ResponseEntity<>(response, HttpStatus.OK);
//       return "sales/detailSales";

    } catch (NullPointerException e) {

       // 상품 상세
       SalesDTO result = salesService.detailSales(salesNo);

       // 판매상품 회원번호 조회
       int selectMemberNo = salesService.selectMemberNo(sales.getSalesNo());

       // 멤버 테이블 데이터 조회
       if (memberNo == selectMemberNo) {
          MemberDTO memberResult = memberService.selectMemberData(selectMemberNo);
          response.put("member", memberResult);
//          model.addAttribute("member", memberResult);
       } else {
          MemberDTO memberResult = memberService.selectMemberData(selectMemberNo);
          response.put("member", memberResult);
//          model.addAttribute("member", memberResult);
       }

       response.put("sales", result);
//       model.addAttribute("sales", result);

       return new ResponseEntity<>(response, HttpStatus.OK);
    }
 }

//판매 등록
@PostMapping("/enrollSales.do")
public ResponseEntity<?> enrollSales(SalesDTO sales, List<MultipartFile> uploads, HttpSession session) {
//	public String enrollSales(SalesDTO sales, List<MultipartFile> uploads, HttpSession session) {

  int memberNo = (int) session.getAttribute("memberNo");
  sales.setMemberNo(memberNo);

  int result = salesService.enrollSales(sales);

  int salesNoSelect = salesService.salesNoSelect();
  sales.setSalesNo(salesNoSelect);

  // 업로드된 파일이 존재하는지 확인
  for (MultipartFile m : uploads) {
     if (m != null && !m.isEmpty()) {
        UploadFile.uploadMethod(m, sales, session);
        int imageInsert = salesService.imageInsert(sales);
     }
  }

  if (result == 1) {
     // 판매 번호 조회
     int selectSalesNo = salesService.selectSalesNo(memberNo);
     sales.setSalesNo(selectSalesNo);
     // 판매 상태 : 판매 중
     int statusResult = salesService.salesStatus(sales.getSalesNo());
     return new ResponseEntity<>("success", HttpStatus.OK);
//     return "redirect:/sales/manageSalesForm.do";
  } else {
	  return new ResponseEntity<>("error", HttpStatus.OK);
//     return "common/error";
  }
}

//   찜 목록 추가
   @GetMapping("/likeBtn.do")
   @ResponseBody
   public ResponseEntity<?> likeBtn(@RequestParam("salesNo") int salesNo, SalesDTO sales, HttpSession session) {
//	   public String likeBtn(@RequestParam("salesNo") int salesNo, SalesDTO sales, HttpSession session) {
      int memberNo = (int) session.getAttribute("memberNo");

      sales.setMemberNo(memberNo);
      sales.setSalesNo(salesNo);

      // 찜 목록 추가
      int result = salesService.likeBtn(sales);

      // 찜 카운트 증가
      int updateLikesCount = salesService.updateLikesCount(sales);

      if (result == 1) {
    	  return new ResponseEntity<>("success", HttpStatus.OK);
//         return "success";
      } else {
    	  return new ResponseEntity<>("failed", HttpStatus.OK);
//         return "failed";
      }
   }

}