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
	public String payPage(@RequestParam(value = "salesNo") int salesNo, PayDTO pay, SalesDTO sales, Model model,
			HttpSession session) {
		
		//데이터 불러오기(salesService 사용)
		SalesDTO salesCheck = salesService.payCheck(salesNo);

		model.addAttribute("salesCheck", salesCheck);
		
		
//		pay.setSalesNo(salesNo);

		return "pay/payCheckPage";
	}

//	결제 완료 페이지로 이동
	@PostMapping("/paying.do")
	public String paying(PayDTO pay, HttpSession session) {

		int memberNo = (int) session.getAttribute("memberNo");
		pay.setMemberNo(memberNo);

		return "pay/payComplete";

	}
}