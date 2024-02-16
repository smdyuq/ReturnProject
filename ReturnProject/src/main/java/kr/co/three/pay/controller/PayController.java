package kr.co.three.pay.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RestController;

import kr.co.three.member.dto.MemberDTO;
import kr.co.three.member.service.MemberServiceImpl;
import kr.co.three.pay.dto.PayDTO;
import kr.co.three.pay.service.PayServiceImpl;
import kr.co.three.sales.dto.SalesDTO;
import kr.co.three.sales.service.SalesServiceImpl;

@RestController
@RequestMapping("/pay")
public class PayController {

	@Autowired
	private PayServiceImpl payService;

	@Autowired
	private SalesServiceImpl salesService;

	@Autowired
	private MemberServiceImpl memberService;

//	결제확인 페이지로 이동(sales dao,serviceImpl에서 처리)@
	@GetMapping("/payCheckPage.do")
	public ResponseEntity<?> payPage(@RequestParam(value = "salesNo") int salesNo, @RequestParam(value = "type") String type,
			SalesDTO sales, Model model, HttpSession session) {
//		public String payPage(@RequestParam(value = "salesNo") int salesNo, @RequestParam(value = "type") String type,
//				SalesDTO sales, Model model, HttpSession session) {

		// sales 데이터 불러오기
		SalesDTO salesCheck = salesService.payCheck(salesNo);

		Map<String, Object> response = new HashMap<>();
		
		response.put("salesCheck", salesCheck);
		response.put("type", type);
//		model.addAttribute("salesCheck", salesCheck);
		return new ResponseEntity<>(response, HttpStatus.OK); // 'pay/payDirectPage'는 직거래 페이지를 렌더링하는데 필요한 view의 이름입니다.

		
		//vue에서 type을 확인 후 어느 페이지로 이동할지 확인해야함.
//		if ("direct".equals(type)) {
//			return new ResponseEntity<>(response, HttpStatus.OK); // 'pay/payDirectPage'는 직거래 페이지를 렌더링하는데 필요한 view의 이름입니다.
////			return "pay/payDirectPage.do"; // 'pay/payDirectPage'는 직거래 페이지를 렌더링하는데 필요한 view의 이름입니다.
//		} else if ("delivery".equals(type)) {
//			return new ResponseEntity<>(response, HttpStatus.OK); // 'pay/payDeliveryPage'는 택배거래 페이지를 렌더링하는데 필요한 view의 이름입니다.
////			return "pay/payDeliveryPage.do"; // 'pay/payDeliveryPage'는 택배거래 페이지를 렌더링하는데 필요한 view의 이름입니다.
//		} else {
//			return new ResponseEntity<>("error", HttpStatus.OK); // 'error'는 잘못된 요청이 들어왔을 때 렌더링하는데 필요한 view의 이름입니다.
////			return "error"; // 'error'는 잘못된 요청이 들어왔을 때 렌더링하는데 필요한 view의 이름입니다.
//		}
	}

//	결제 완료 페이지로 이동(삭제??)
//	@PostMapping("/paying.do")
//	public String paying(PayDTO pay, HttpSession session) {
//
//		int memberNo = (int) session.getAttribute("memberNo");
//		pay.setMemberNo(memberNo);
//
//		return "pay/payComplete";
//
//	}


	//모달에서 직거래 클릭했을때@

	@GetMapping("/payDirectPage.do")
	public ResponseEntity<?> DirectPayPage(@RequestParam(value = "salesNo") int salesNo, PayDTO pay, SalesDTO sales, Model model,
			HttpSession session) {
//		public String DirectPayPage(@RequestParam(value = "salesNo") int salesNo, PayDTO pay, SalesDTO sales, Model model,
//				HttpSession session) {

		SalesDTO salesCheck = salesService.payCheck(salesNo);

		 Map<String, Object> response = new HashMap<>();
		 response.put("salesCheck", salesCheck);
//		model.addAttribute("salesCheck", salesCheck);

		 return new ResponseEntity<>(response, HttpStatus.OK);
//		return null;
	}


	//모달에서 택배거래 클릭했을때@

	@GetMapping("/payDeliveryPage.do")
	public ResponseEntity<?> DeliveryPayPage(@RequestParam(value = "salesNo") int salesNo, MemberDTO member, PayDTO pay,
			SalesDTO sales, Model model, HttpSession session) {
//		public String DeliveryPayPage(@RequestParam(value = "salesNo") int salesNo, MemberDTO member, PayDTO pay,
//				SalesDTO sales, Model model, HttpSession session) {

		SalesDTO salesCheck = salesService.payCheck(salesNo);

		int memberNo = (int) session.getAttribute("memberNo");
		member.setMemberNo(memberNo);

		member = memberService.selectMemberData(memberNo);

		Map<String, Object> response = new HashMap<>();
		response.put("salesCheck", salesCheck);
		response.put("member", member);
//		model.addAttribute("salesCheck", salesCheck);
//		model.addAttribute("member", member);

		return new ResponseEntity<>(response, HttpStatus.OK);
//		return null;

	}

//	직거래 결제완료 페이지 불러오기@
	@PostMapping("/payDirectComplete.do")
	public ResponseEntity<?> payDirectComplete(PayDTO pay, HttpSession session, SalesDTO sales) {
//		public String payDirectComplete(PayDTO pay, HttpSession session, SalesDTO sales) {
		int memberNo = (int) session.getAttribute("memberNo");
		pay.setMemberNo(memberNo);
		pay.setPayMethod("카카오 페이");
		pay.setPayReceipt("직거래");

		// 총 가격
		pay.setPayAllPrice(sales.getSalesPrice() * sales.getSalesCount());

		sales.setSalesNo(pay.getSalesNo());

		// 직거래용 페이 테이블 인설트
		int result = payService.insertDirectPay(pay);

		// 판매 수량 업데이트
		int updateCount = salesService.updateCount(sales);

		// 상품 판매 수 업데이트
		int updateCompleteCount = salesService.updateCompleteCount(sales);

		// 상품 상태 업데이트
		int salesStatusUpdate = salesService.salesStatusUpdate(sales);

		return new ResponseEntity<>("sussece", HttpStatus.OK);
//		return "pay/payComplete";
	}

//	택배거래-결제완료 페이지 @
	@PostMapping("/payDeliveryComplete.do")
	public ResponseEntity<?> payDeliveryComplete(PayDTO pay, HttpSession session, SalesDTO sales) {
//		public String payDeliveryComplete(PayDTO pay, HttpSession session, SalesDTO sales) {
		int memberNo = (int) session.getAttribute("memberNo");
		pay.setMemberNo(memberNo);
		pay.setPayMethod("카카오 페이");
		pay.setPayReceipt("택배거래");

		// 총 가격
		pay.setPayAllPrice((sales.getSalesPrice() * sales.getSalesCount()) + sales.getSalesDelivery());

		// 택배거래용 페이 테이블 인설트
		int result = payService.insertDeliveryPay(pay);

		// 판매 수량 업데이트
		int updateCount = salesService.updateCount(sales);

		// 상품 판매 수 업데이트
		int updateCompleteCount = salesService.updateCompleteCount(sales);

		// 상품 상태 업데이트
		int salesStatusUpdate = salesService.salesStatusUpdate(sales);

		return new ResponseEntity<>("sussece", HttpStatus.OK);
//		return "pay/payComplete";
	}

//	에러
//	@GetMapping("/payError.do")
//	public String payError() {
//
//		return "common/error";
//	}

}
