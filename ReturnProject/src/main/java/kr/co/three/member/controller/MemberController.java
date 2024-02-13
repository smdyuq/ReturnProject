package kr.co.three.member.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.three.common.UploadFile;
import kr.co.three.member.dto.MemberDTO;
import kr.co.three.member.service.MemberServiceImpl;
import kr.co.three.sales.dto.SalesDTO;
import kr.co.three.sales.service.SalesServiceImpl;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberServiceImpl memberService;

	@Autowired
	private SalesServiceImpl salesService;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

//	회원가입
	@PostMapping("/register.do")
	public String register(MemberDTO member) {

//		패스워드 암호화
		String pwd = bcryptPasswordEncoder.encode(member.getMemberPwd());
		member.setMemberPwd(pwd);

		int result = memberService.registerMember(member);

		if (result == 1) {
			return "redirect:/";
		} else {
			return "common/error";
		}
	}

//	// 회원가입
//	@PostMapping("/register")
//	public ResponseEntity<?> register(@RequestBody MemberDTO member) {
//
//		String pwd = bcryptPasswordEncoder.encode(member.getMemberPwd());
//		member.setMemberPwd(pwd);
//
//		int result = memberService.registerMember(member);
//
//		if (result == 1) {
//			return new ResponseEntity<>("success", HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>("error", HttpStatus.OK);
//		}
//	}

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
	public String login(MemberDTO member, HttpSession session) {

		MemberDTO loginUser = memberService.loginMember(member);

		// loginUser 객체가 비어있지 않을 때 (로그인 성공)
		if (!Objects.isNull(loginUser)
				&& bcryptPasswordEncoder.matches(member.getMemberPwd(), loginUser.getMemberPwd())) {
			session.setAttribute("memberNo", loginUser.getMemberNo());
			session.setAttribute("memberId", loginUser.getMemberId());
			session.setAttribute("memberType", loginUser.getMemberType());

			return "redirect:/";
		} else {
			return "common/error";
		}
	}

//	로그아웃
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/";
	}

//	내 상점
	@GetMapping("storeForm.do")
	public String storeForm(@RequestParam(value = "memberNo") int memberNo, HttpSession session, Model model) {
		// 클라이언트에서 새로고침 이벤트를 감지하여 서버에 요청을 보내지 않도록 처리
		boolean isRefreshRequest = isRefreshRequest(session);
		if (!isRefreshRequest) {
			// 상점 방문 수 증가
			int storeVisitCount = memberService.storeVisitCount(memberNo);
		}

		// 멤버 테이블 데이터 조회
		MemberDTO memberResult = memberService.selectMemberData(memberNo);
		// 상품 테이블 데이터 조회
		List<SalesDTO> salesResult = memberService.selectSalesData(memberNo);
		// 찜 조회
		List<SalesDTO> likeResult = memberService.selectLikeData(memberNo);

		model.addAttribute("member", memberResult);
		model.addAttribute("sales", salesResult);
		model.addAttribute("like", likeResult);

		return "member/store";
	}

	private boolean isRefreshRequest(HttpSession session) {
		// 이전 요청 시간을 세션에 저장하여 새로고침 여부를 확인
		Long previousRequestTime = (Long) session.getAttribute("previousRequestTime");
		long currentRequestTime = System.currentTimeMillis();
		session.setAttribute("previousRequestTime", currentRequestTime);

		// 이전 요청 시간이 존재하지 않거나, 일정 시간 내에 중복 요청이 들어온 경우 새로고침으로 간주
		long refreshInterval = 1000; // 1초
		return previousRequestTime != null && (currentRequestTime - previousRequestTime) < refreshInterval;
	}

//	상점 이미지 수정폼
	@GetMapping("/storeImageUpdateForm.do")
	public String storeImageUpdateForm() {
		return "member/storeImageUpdate";
	}

//	상점 이미지 수정
	@PostMapping("/storeImageUpdate.do")
	public String storeImageUpdate(HttpSession session, MemberDTO member, MultipartFile upload) {

		int memberNo = (int) session.getAttribute("memberNo");
		member.setMemberNo(memberNo);

		int result = 0;

		UploadFile.uploadMethod(upload, member, session);

		// 상품 수정
		result = memberService.storeImageUpdate(member);

		return "redirect:/member/storeForm.do";
	}

//	소개글 수정
	@PostMapping("/storeContentUpdate.do")
	@ResponseBody
	public String storeContentUpdate(@RequestParam("memberContent") String memberContent, HttpSession session,
			MemberDTO member) {
		int memberNo = (int) session.getAttribute("memberNo");
		member.setMemberNo(memberNo);
		member.setMemberContent(memberContent);

		System.out.println(memberNo);
		System.out.println(memberContent);

		int result = memberService.storeContentUpdate(member);
		System.out.println(result);

		if (result == 1) {
			return "success";
		} else {
			return "error";
		}
	}

	// 회원가입 폼으로 이동
	@GetMapping("/registerForm.do")
	public String registerForm() {
		return "member/register";
	}

	// 로그인 폼으로 이동
	@GetMapping("/loginForm.do")
	public String loginForm() {
		return "member/login";
	}

}
