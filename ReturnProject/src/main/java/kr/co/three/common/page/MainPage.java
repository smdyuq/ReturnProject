package kr.co.three.common.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPage {

	@RequestMapping("/")
	public String mainPage() {
		return "main";
	}

}