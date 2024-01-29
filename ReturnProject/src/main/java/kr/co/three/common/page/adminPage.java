package kr.co.three.common.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminPage {

	@RequestMapping("/admin")
	public String adminPage() {
		return "admin/adminLogin";
	}
}
