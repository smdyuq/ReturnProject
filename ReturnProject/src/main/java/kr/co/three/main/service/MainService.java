package kr.co.three.main.service;

import java.util.List;

import kr.co.three.main.dto.MainDTO;
import kr.co.three.sales.dto.SalesDTO;

public interface MainService {

//	검색 페이지 검색 데이터 등록
	int insertSearch(MainDTO main);
	
//	검색 데이터 리스트
	List<MainDTO> searchList(MainDTO main);

//	상품 리스트
	List<SalesDTO> mainSalesList(SalesDTO sales);

}
