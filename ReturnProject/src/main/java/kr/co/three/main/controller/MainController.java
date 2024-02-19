package kr.co.three.main.controller;

import java.util.ArrayList;
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

import kr.co.three.main.dto.MainDTO;
import kr.co.three.main.service.MainServiceImpl;
import kr.co.three.sales.dto.SalesDTO;

@Controller
public class MainController {

	@Autowired
	private MainServiceImpl mainService;

//	메인 페이지로 이동
	@RequestMapping("/")
	public String mainPage(SalesDTO sales, Model model) {

		// 상품 리스트
		List<SalesDTO> list = mainService.mainSalesList(sales);

		model.addAttribute("sales", list);

		return "main/mainPage";
	}

//@RestController
//@RequestMapping("/main")
//public class MainController {
//
//	@Autowired
//	private MainServiceImpl mainService;
//
//	// 메인 페이지
//	@GetMapping("/mainPage")
//	public ResponseEntity<?> mainPage(SalesDTO sales) {
//
//		// response.data
//		List<SalesDTO> salesList = mainService.mainSalesList(sales);
//
//		// response.data.list
//		HashMap<String, Object> response = new HashMap<>();
//		response.put("list", salesList);
//
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}

//	검색 페이지로 이동
	@PostMapping("/main/search.do")
	public String search(SalesDTO sales, MainDTO main, Model model, HttpSession session) {
		try {
			int memberNo = (int) session.getAttribute("memberNo");
			main.setMemberNo(memberNo);

			// 중복 등록 체크
			int isDuplicate = mainService.SearchWordDuplicate(main);
			if (isDuplicate != 1) {
				// 검색 페이지 검색 데이터 등록
				int result = mainService.insertSearch(main);
			}

			// 검색 데이터 리스트
			List<MainDTO> searchList = mainService.searchList(main);

			// 상품 리스트
			List<SalesDTO> salesList = mainService.mainSalesList(sales);

			model.addAttribute("sales", salesList);
			model.addAttribute("search", searchList);

			return "main/searchPage";

		} catch (NullPointerException e) {

			// 검색 데이터 리스트
			List<MainDTO> searchList = mainService.searchList(main);

			// 상품 리스트
			List<SalesDTO> salesList = mainService.mainSalesList(sales);

			model.addAttribute("sales", salesList);
			model.addAttribute("search", searchList);

			return "main/searchPage";
		}
	}

//	최근 검색어 삭제
	@PostMapping("/main/deleteSearch.do")
	@ResponseBody
	public String deleteSearch(@RequestParam("searchNo") int searchNo) {
		int result = mainService.deleteSearch(searchNo);
		if (result == 1) {
			return "success";
		} else {
			return "failed";
		}
	}

// 	카테고리 페이지로 이동
	@GetMapping("/main/categorySales.do")
	public String category(@RequestParam("salesCategory") String salesCategory, Model model) {

		List<SalesDTO> salesList = new ArrayList<>();

		if (salesCategory.equals("가전")) {
			// 가전 카테고리
			salesList = mainService.homeAppliances();
		} else if (salesCategory.equals("의류")) {
			// 의류 카테고리
			salesList = mainService.clothes();
		} else if (salesCategory.equals("향수")) {
			// 향수 카테고리
			salesList = mainService.perfume();
		} else if (salesCategory.equals("푸드")) {
			// 푸드 카테고리
			salesList = mainService.food();
		} else if (salesCategory.equals("주얼리")) {
			// 주얼리 카테고리
			salesList = mainService.jewelry();
		}

		model.addAttribute("sales", salesList);

		return "main/categoryPage";
	}

//	배너 페이지로 이동
	@GetMapping("/main/bannerPage.do")
	public String banner() {

		return "main/bannerPage";
	}

}