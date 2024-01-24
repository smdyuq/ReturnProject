package kr.co.three.sales.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.three.sales.dto.SalesDTO;
import kr.co.three.sales.service.SalesServiceImpl;

@Controller
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	private SalesServiceImpl salesService;

//	판매하기 페이지로 이동
	@GetMapping("/enrollSalesForm.do")
	public String enrollSalesForm() {
		return "sales/enrollSales";
	}

//	판매등록
	@PostMapping("/enrollSales.do")
	public String enrollSales(SalesDTO sales, HttpSession session) {
		sales.setSalesImageName("임시 이미지 이름");
		sales.setSalesImagePath("임시 이미지 경로");

		int memberNo = (int) session.getAttribute("memberNo");
		sales.setMemberNo(memberNo);
		
		int result = salesService.enrollSales(sales);

		if (result == 1) {
			return "main";
		} else {
			return "common/error";
		}
	}
}