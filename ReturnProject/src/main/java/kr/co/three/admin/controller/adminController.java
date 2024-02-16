package kr.co.three.admin.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.three.admin.dto.adminDTO;
import kr.co.three.admin.service.adminServiceImpl;

@RestController
@RequestMapping("/admin")
public class adminController {

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	private adminServiceImpl adminService;

////	가입 폼으로 이동
//	@GetMapping("/registerForm.do")
//	public String registerForm() {
//		return "admin/member/adminRegister";
//	}
//
//////	로그인 폼으로 이동
//	@GetMapping("/loginForm.do")
//	public String loginForm() {
//		return "admin/main/adminMain";
//	}

//	관리자 등록
	@PostMapping("/register.do")
	public ResponseEntity<?> register(adminDTO admin) {

		admin.setMemberPhone("01012345678");
		admin.setMemberType(0);
		

//		패스워드 암호화
		String pwd = bcryptPasswordEncoder.encode(admin.getMemberPwd());
		admin.setMemberPwd(pwd);

		int result = adminService.registerAdmin(admin);

		if (result == 1) {
	        return new ResponseEntity<>("success", HttpStatus.OK);
//			return "admin/member/adminLogin";
		} else {
			return new ResponseEntity<>("error", HttpStatus.OK);
//			return "common/error";
		}
	}

//	아이디 중복검사
	@PostMapping("/checkId.do")
	@ResponseBody
	public ResponseEntity<?> checkId(String adminId) {
//		public String checkId(String adminId) {

		// 아이디 중복검사
		int result = adminService.checkId(adminId);

		if (result == 1) {
			return new ResponseEntity<>("duplication", HttpStatus.OK);
//			return "duplication";
		} else {
			return new ResponseEntity<>("available", HttpStatus.OK);
//			return "available";
		}
	}

//	로그인
	@PostMapping("/login.do")
	public ResponseEntity<?> loginIndex(adminDTO admin, HttpSession session, Model model) {

		adminDTO loginAdmin = adminService.loginAdmin(admin);
		// loginUser 객체가 비어있지 않을 때 (로그인 성공)
//		if (!Objects.isNull(loginAdmin)
//				&& bcryptPasswordEncoder.matches(admin.getMemberPwd(), loginAdmin.getMemberPwd())) {
//			session.setAttribute("memberNo", loginAdmin.getMemberNo());
//			session.setAttribute("memberId", loginAdmin.getMemberId());
//			session.setAttribute("memberType", loginAdmin.getMemberType());
//
//			model.addAttribute("admin", admin);
//			return "admin/main/adminMain";
//		} else {
//			return "common/error";
//		}
		 if (!Objects.isNull(loginAdmin)
		            && bcryptPasswordEncoder.matches(admin.getMemberPwd(), loginAdmin.getMemberPwd())
		            && loginAdmin.getMemberType() == 0) {
			 
		        session.setAttribute("memberNo", loginAdmin.getMemberNo());
		        session.setAttribute("memberId", loginAdmin.getMemberId());
		        session.setAttribute("memberType", loginAdmin.getMemberType());
		        
		        Map<String, Object> response = new HashMap<>();
		        response.put("admin", admin);
		        return new ResponseEntity<>(response, HttpStatus.OK);
//		        return "admin/main/adminMain";
		    } else {
		    	return new ResponseEntity<>("error", HttpStatus.OK);
//		        return "common/error";
		    }
	}

	// 로그아웃
	@GetMapping("/logout.do")
	public ResponseEntity<?> logout(HttpSession session) {
//		public String logout(HttpSession session) {

		session.removeAttribute("memberNo");
		session.invalidate();

		return new ResponseEntity<>("success", HttpStatus.OK);
//		return "admin/member/adminLogin";
	}

}
