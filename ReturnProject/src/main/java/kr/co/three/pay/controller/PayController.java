package kr.co.three.pay.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.three.pay.dto.PayDTO;
import kr.co.three.pay.service.PayServiceImpl;
import kr.co.three.sales.dto.SalesDTO;
import kr.co.three.sales.service.SalesServiceImpl;

@Controller
@RequestMapping("/pay")
public class PayController {

	@Autowired
	private PayServiceImpl payService;
	
	@Autowired
	private SalesServiceImpl salesService;
	
//	결제확인 페이지로 이동
	@GetMapping("/payCheckPage.do")
	public String payPage(@RequestParam(value = "salesNo") int salesNo, @RequestParam(value = "type") String type, SalesDTO sales, Model model,
			HttpSession session) {
		
		//데이터 불러오기(salesService 사용)
		SalesDTO salesCheck = salesService.payCheck(salesNo);

		model.addAttribute("salesCheck", salesCheck);
		
		
		if ("direct".equals(type)) {
	        return "pay/payDirectPage.do"; // 'pay/payDirectPage'는 직거래 페이지를 렌더링하는데 필요한 view의 이름입니다.
	    } else if ("delivery".equals(type)) {
	        return "pay/payDeliveryPage.do"; // 'pay/payDeliveryPage'는 택배거래 페이지를 렌더링하는데 필요한 view의 이름입니다.
	    } else {
	        return "error"; // 'error'는 잘못된 요청이 들어왔을 때 렌더링하는데 필요한 view의 이름입니다.
	    }
	}

//	결제 완료 페이지로 이동
	@PostMapping("/paying.do")
	public String paying(PayDTO pay, HttpSession session) {

		int memberNo = (int) session.getAttribute("memberNo");
		pay.setMemberNo(memberNo);

		return "pay/payComplete";

	}
	
	@GetMapping("/payDirectPage.do")
	public String payPage(@RequestParam(value = "salesNo") int salesNo, PayDTO pay, SalesDTO sales, Model model,
			HttpSession session) {
		

		SalesDTO salesCheck = salesService.payCheck(salesNo);

		model.addAttribute("salesCheck", salesCheck);
		
		
		return null;
		
		
		
		
		
		//pay 테이블 등록(결재에서 써야함)
//		pay.setPayReceipt("직거래");
//		pay.setPayAddress("직거래");
		
		
//		session.setAttribute("salesNo", salesNo);
//	    int memberNo = (int) session.getAttribute("memberNo");
//
//	    int salesNum = (int) session.getAttribute("salesNo"); // 세션에서 salesNo 값을 가져옴
//		System.out.println(salesNum);
//		System.out.println(memberNo);
//		pay.setSalesNo(salesNum);
//		pay.setMemberNo(memberNo);
//		
//		
//		int result = payService.insertPay(pay);
//		
//		
//
//		if (result == 1) {
//			return "redirect:/pay/payDirectPage.do";
//		} else {
//			return "common/error";
//		}
	}
	
	
	
	
	
	
	
}

