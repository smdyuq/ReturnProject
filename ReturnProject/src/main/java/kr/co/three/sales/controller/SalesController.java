package kr.co.three.sales.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.three.common.PageInfo;
import kr.co.three.common.Pagination;
import kr.co.three.common.UploadFile;
import kr.co.three.member.dto.MemberDTO;
import kr.co.three.member.service.MemberServiceImpl;
import kr.co.three.sales.dto.SalesDTO;
import kr.co.three.sales.service.SalesServiceImpl;

@Controller
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	private SalesServiceImpl salesService;

	@Autowired
	private MemberServiceImpl memberService;

//	판매하기 페이지로 이동
	@GetMapping("/enrollSalesForm.do")
	public String enrollSalesForm() {
		return "sales/enrollSales";
	}

//	상품관리 페이지로 이동
	@GetMapping("manageSalesForm.do")
	public String manageSalesForm(SalesDTO sales, @RequestParam(value = "cpage", defaultValue = "1") int cpage,
			Model model, HttpSession session) {

		int memberNo = (int) session.getAttribute("memberNo");
		sales.setMemberNo(memberNo);

		// 전체 게시글 수 구하기
		int listCount = salesService.salesSelectListCount(sales);
		int pageLimit = 5;
		int boardLimit = 8;

		// 게시글 번호
		// 26
		int row = listCount - (cpage - 1) * boardLimit;

		PageInfo pi = Pagination.getPageInfo(listCount, cpage, pageLimit, boardLimit);

		// 목록 불러오기
		List<SalesDTO> list = salesService.salesSelectListAll(pi, sales);

		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		model.addAttribute("row", row);
		return "sales/manageSales";
	}

//	상품수정 페이지로 이동
	@GetMapping("updateSalesForm.do")
	public String updateSalesForm(@RequestParam(value = "salesNo") int salesNo, Model model) {
		SalesDTO result = salesService.updateSalesForm(salesNo);

		model.addAttribute("sales", result);
		return "sales/updateSales";
	}

//	상품 수정
	@PostMapping("updateSales.do")
	public String updateSales(SalesDTO sales, HttpSession session, MultipartFile upload) {

		// 판매등록 작성자 조회
		int salesMember = salesService.selectSalesMember(sales.getSalesNo()); // 판매등록 작성자

		int memberNo = (int) session.getAttribute("memberNo"); // 로그인 유저

		int result = 0;

		if (salesMember == memberNo && !upload.isEmpty()) {
			// 기존 파일이름 조회
			String fileName = salesService.selectFileName(sales.getSalesNo());

			sales.setSalesImageName(fileName);

			boolean deleteFile = UploadFile.deleteFile(fileName);

			if (deleteFile) {
				UploadFile.uploadMethod(upload, sales, session);

				// 상품 수정
				result = salesService.updateSales(sales);
			}
		}
		if (salesMember == memberNo) {
			// upload가 비어있을 경우 : 기존 업로드 정보 유지
			// uploadPath, uploadName, uploadOriginName이 비워져있는 상태

			// 상품 수정(upload가 비어있을 때)
			result = salesService.updateSalesEmptyUpload(sales);
		}

		if (result == 1) {
			return "redirect:/sales/manageSalesForm.do";
		} else {
			return "common/error";
		}
	}

//	상품 삭제
	@GetMapping("deleteSales.do")
	public String deleteSales(@RequestParam(value = "salesNo") int salesNo) {

		int result = salesService.deleteSales(salesNo);

		return "redirect:/sales/manageSalesForm.do";

	}

//	상품 상세
	@GetMapping("detailSales.do")
	public String detailSales(@RequestParam(value = "salesNo") int salesNo, SalesDTO sales, Model model,
			HttpSession session) {

		int memberNo = 0;

		try {
			memberNo = (int) session.getAttribute("memberNo");
			sales.setMemberNo(memberNo);
			sales.setSalesNo(salesNo);

			// 최근 본 상품
			int recentSales = salesService.recentSales(sales);

			// 상품 상세
			SalesDTO result = salesService.detailSales(salesNo);

			// 판매상품 회원번호 조회
			int selectMemberNo = salesService.selectMemberNo(sales.getSalesNo());

			// 멤버 테이블 데이터 조회
			if (memberNo == selectMemberNo) {
				MemberDTO memberResult = memberService.selectMemberData(selectMemberNo);
				model.addAttribute("member", memberResult);
			} else {
				MemberDTO memberResult = memberService.selectMemberData(selectMemberNo);
				model.addAttribute("member", memberResult);
			}

			model.addAttribute("sales", result);

			return "sales/detailSales";

		} catch (NullPointerException e) {

			// 상품 상세
			SalesDTO result = salesService.detailSales(salesNo);

			// 판매상품 회원번호 조회
			int selectMemberNo = salesService.selectMemberNo(sales.getSalesNo());

			// 멤버 테이블 데이터 조회
			if (memberNo == selectMemberNo) {
				MemberDTO memberResult = memberService.selectMemberData(selectMemberNo);
				model.addAttribute("member", memberResult);
			} else {
				MemberDTO memberResult = memberService.selectMemberData(selectMemberNo);
				model.addAttribute("member", memberResult);
			}

			model.addAttribute("sales", result);

			return "sales/detailSales";
		}
	}

//	판매 등록
	@PostMapping("/enrollSales.do")
	public String enrollSales(SalesDTO sales, MultipartFile upload, HttpSession session) {

		int memberNo = (int) session.getAttribute("memberNo");
		sales.setMemberNo(memberNo);

		// 업로드된 파일이 존재하는지 확인
		if (upload != null && !upload.isEmpty()) {
			UploadFile.uploadMethod(upload, sales, session);
		}

		int result = salesService.enrollSales(sales);

		if (result == 1) {
			// 판매 번호 조회
			int selectSalesNo = salesService.selectSalesNo(memberNo);
			sales.setSalesNo(selectSalesNo);
			// 판매 상태 : 판매 중
			int statusResult = salesService.salesStatus(sales.getSalesNo());
			return "redirect:/sales/manageSalesForm.do";
		} else {
			return "common/error";
		}
	}

//	찜 목록 추가
	@GetMapping("/likeBtn.do")
	@ResponseBody
	public String likeBtn(@RequestParam("salesNo") int salesNo, SalesDTO sales, HttpSession session) {
		int memberNo = (int) session.getAttribute("memberNo");

		sales.setMemberNo(memberNo);
		sales.setSalesNo(salesNo);

		// 찜 목록 추가
		int result = salesService.likeBtn(sales);

		int updateLikesCount = salesService.updateLikesCount(sales);

		if (result == 1) {
			return "success";
		} else {
			return "failed";
		}
	}

}