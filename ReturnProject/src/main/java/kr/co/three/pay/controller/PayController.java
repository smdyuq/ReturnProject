package kr.co.three.pay.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.three.member.service.MemberServiceImpl;
import kr.co.three.pay.dto.PayDTO;
import kr.co.three.sales.dto.SalesDTO;

@Controller
@RequestMapping("/pay")
public class PayController {
	
	@Autowired
	private MemberServiceImpl memberService;

//	결제 페이지로 이동
	@GetMapping("/payPage.do")
//	public String payPage(@RequestParam("salesNo") int salesNo, PayDTO pay, SalesDTO sales, HttpSession session) {
	public String payPage(PayDTO pay, SalesDTO sales, HttpSession session) {

		int salesNo = (int) session.getAttribute("salesNo");
		
		
		System.out.println("a"+pay.getMemberNo());
		System.out.println("b"+sales.getSalesCategory());
		
		sales.setSalesNo(salesNo);
		List<SalesDTO> salesResult = memberService.selectSalesData(salesNo);

		
		
		return "pay/payPage";
	}

//	결제 완료 페이지로 이동
	@PostMapping("/paying.do")
	public String paying(PayDTO pay, HttpSession session) {

		int memberNo = (int) session.getAttribute("memberNo");
		pay.setMemberNo(memberNo);

		return "pay/payComplete";

	}
}