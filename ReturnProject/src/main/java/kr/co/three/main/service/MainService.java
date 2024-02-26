package kr.co.three.main.service;

import java.util.List;

import kr.co.three.main.dto.MainDTO;
import kr.co.three.sales.dto.SalesDTO;

public interface MainService {

//	중복 등록 체크
	int SearchWordDuplicate(MainDTO main);

//	검색 페이지 검색 데이터 등록
	int insertSearch(MainDTO main);

//	검색 데이터 리스트
	List<MainDTO> searchList(MainDTO main);

//	최근 검색어 삭제
	int deleteSearch(int searchNo);

//	상품 리스트
	List<SalesDTO> mainSalesList(SalesDTO sales);

//	<카테고리 페이지>

//	전체 카테고리
	List<SalesDTO> all();

//	가전 카테고리
	List<SalesDTO> homeAppliances();

//	의류 카테고리
	List<SalesDTO> clothes();

//	식품 카테고리
	List<SalesDTO> food();

//	주얼리 카테고리
	List<SalesDTO> jewelry();

}