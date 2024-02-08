package kr.co.three.sales.service;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.three.common.PageInfo;
import kr.co.three.sales.dao.SalesDAO;
import kr.co.three.sales.dto.SalesDTO;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesDAO salesDAO;

	@Autowired
	private SqlSessionTemplate sqlSession;

//	상품관리 전체 리스트 수
	@Override
	public int salesSelectListCount(SalesDTO sales) {
		return salesDAO.salesSelectListCount(sales, sqlSession);
	}

//	상품관리 목록 불러오기
	@Override
	public List<SalesDTO> salesSelectListAll(PageInfo pi, SalesDTO sales) {
		return salesDAO.salesSelectListAll(pi, sales, sqlSession);
	}

//	상품 수정 폼 이동
	@Override
	public SalesDTO updateSalesForm(int salesNo) {
		return salesDAO.updateSalesForm(salesNo, sqlSession);
	}

//	상품 수정
	@Override
	public int updateSales(SalesDTO sales) {
		return salesDAO.updateSales(sales, sqlSession);
	}

//	상품 삭제
	@Override
	public int deleteSales(int salesNo) {
		return salesDAO.deleteSales(salesNo, sqlSession);
	}

//	상품 상세
	@Override
	public SalesDTO detailSales(int salesNo) {
		return salesDAO.detailSales(salesNo, sqlSession);
	}

//	최근 본 상품
	@Override
	public int recentSales(SalesDTO sales) {
		return salesDAO.recentSales(sales, sqlSession);
	}

//	판매 등록
	@Override
	public int enrollSales(SalesDTO sales) {
		return salesDAO.enrollSales(sales, sqlSession);
	}

//	판매등록 작성자 조회
	@Override
	public int selectSalesMember(int salesNo) {
		return salesDAO.selectSalesMember(salesNo, sqlSession);
	}

//	기존 파일이름 조회
	@Override
	public String selectFileName(int salesNo) {
		return salesDAO.selectFileName(salesNo, sqlSession);
	}

//	상품 수정(upload가 비어있을 때)
	@Override
	public int updateSalesEmptyUpload(SalesDTO sales) {
		return salesDAO.updateSalesEmptyUpload(sales, sqlSession);
	}

//	찜 목록 추가
	@Override
	public int likeBtn(SalesDTO sales) {
		return salesDAO.likeBtn(sales, sqlSession);
	}

//	판매 상태 : 판매 중
	@Override
	public int salesStatus(int salesNo) {
		return salesDAO.salesStatus(salesNo, sqlSession);
	}

//	결제 정보 체크
	@Override
	public SalesDTO payCheck(int salesNo) {
		return salesDAO.payCheck(salesNo, sqlSession);
	}

//	판매 번호 조회
	@Override
	public int selectSalesNo(int memberNo) {
		return salesDAO.selectSalesNo(memberNo, sqlSession);
	}

//	판매상품 회원번호 조회
	@Override
	public int selectMemberNo(int salesNo) {
		return salesDAO.selectMemberNo(salesNo, sqlSession);
	}

//	찜 카운트 증가
	@Override
	public int updateLikesCount(SalesDTO sales) {
		return salesDAO.updateLikesCount(sales, sqlSession);
	}

}