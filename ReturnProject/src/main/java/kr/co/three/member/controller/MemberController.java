package kr.co.three.member.controller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.three.member.dto.MemberDTO;
import kr.co.three.member.service.MemberServiceImpl;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberServiceImpl memberService;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

//	회원가입 폼으로 이동
	@GetMapping("/registerForm.do")
	public String registerForm() {
		return "member/register";
	}

//	로그인 폼으로 이동
	@GetMapping("/loginForm.do")
	public String loginForm() {
		return "member/login";
	}

//	회원가입
	@PostMapping("/register.do")
	public String register(MemberDTO member) {

//		임시로 핸드폰 번호 넣어두기
		member.setMemberPhone("01012345678");

//		패스워드 암호화
		String pwd = bcryptPasswordEncoder.encode(member.getMemberPwd());
		member.setMemberPwd(pwd);

		int result = memberService.registerMember(member);

		if (result == 1) {
			return "main";
		} else {
			return "common/error";
		}
	}

//	아이디 중복검사
	@PostMapping("/checkId.do")
	@ResponseBody
	public String checkId(String memberId) {

		// 아이디 중복검사
		int result = memberService.checkId(memberId);

		if (result == 1) {
			return "duplication";
		} else {
			return "available";
		}
	}

//	로그인
	@PostMapping("/login.do")
	public String loginIndex(MemberDTO member, HttpSession session, Model model) {

		MemberDTO loginUser = memberService.loginMember(member);
		// loginUser 객체가 비어있지 않을 때 (로그인 성공)
		if (!Objects.isNull(loginUser)
				&& bcryptPasswordEncoder.matches(member.getMemberPwd(), loginUser.getMemberPwd())) {
			session.setAttribute("memberNo", loginUser.getMemberNo());
			session.setAttribute("memberId", loginUser.getMemberId());
			session.setAttribute("memberType", loginUser.getMemberType());

			model.addAttribute("member", member);
			return "main";
		} else {
			return "common/error";
		}
	}

}
