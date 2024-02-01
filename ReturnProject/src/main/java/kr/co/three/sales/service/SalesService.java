package kr.co.three.sales.service;

import java.util.List;

import kr.co.three.common.PageInfo;
import kr.co.three.main.dto.MainDTO;
import kr.co.three.sales.dto.SalesDTO;

public interface SalesService {

//	상품관리 전체 리스트 수
	int salesSelectListCount(SalesDTO sales);

//	상품관리 목록 불러오기
	List<SalesDTO> salesSelectListAll(PageInfo pi, SalesDTO sales);

//	상품 수정 폼 이동
	SalesDTO updateSalesForm(int salesNo);

//	상품 수정
	int updateSales(SalesDTO sales);

//	상품 삭제
	int deleteSales(int salesNo);

//	상품 상세
	SalesDTO detailSales(int salesNo);
	
//	최근 본 상품
	int recentSales(SalesDTO sales);

//	판매 등록
	int enrollSales(SalesDTO sales);

//	판매등록 작성자 조회
	int selectSalesMember(int memberNo);

//	기존 파일이름 조회
	String selectFileName(int memberNo);

//	상품 수정(upload가 비어있을 때)
	int updateSalesEmptyUpload(SalesDTO sales);

//	찜 목록 추가
	int likeBtn(SalesDTO sales);

}
