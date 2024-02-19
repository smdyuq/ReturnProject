package kr.co.three.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminPage {

//	관리자 페이지로 이동
	@RequestMapping("/admin")
	public String adminPage() {
		return "admin/member/adminLogin";
	}
}