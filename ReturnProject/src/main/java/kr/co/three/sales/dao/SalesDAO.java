package kr.co.three.sales.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.common.PageInfo;
import kr.co.three.pay.dto.PayDTO;
import kr.co.three.sales.dto.SalesDTO;

@Repository
public class SalesDAO {

//   상품관리 전체 리스트 수
	public int salesSelectListCount(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("salesMapper.salesSelectListCount", sales);
	}

//   상품관리 목록 불러오기
	public List<SalesDTO> salesSelectListAll(PageInfo pi, SalesDTO sales, SqlSessionTemplate sqlSession) {
		// 현재 페이지의 게시글을 불러오기 위한 변수
		int offset = (pi.getCpage() - 1) * pi.getBoardLimit();

		// 작은 규모일 경우에만 사용하는것을 권장
		RowBounds rb = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("salesMapper.salesSelectListAll", sales, rb);
	}

//   상품 수정 폼 이동
	public SalesDTO updateSalesForm(int salesNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("salesMapper.updateSalesForm", salesNo);
	}

//   상품 수정
	public int updateSales(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.update("salesMapper.updateSales", sales);
	}

//   상품 삭제
	public int deleteSales(int salesNo, SqlSessionTemplate sqlSession) {
		return sqlSession.delete("salesMapper.deleteSales", salesNo);
	}

//   상품 상세
	public SalesDTO detailSales(int salesNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("salesMapper.detailSales", salesNo);
	}

//   최근 본 상품
	public int recentSales(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("salesMapper.recentSales", sales);
	}

//   판매 등록
	public int enrollSales(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("salesMapper.enrollSales", sales);
	}

//   판매등록 작성자 조회
	public int selectSalesMember(int salesNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("salesMapper.selectSalesMember", salesNo);
	}

//   기존 파일이름 조회
	public String selectFileName(int salesNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("salesMapper.selectFileName", salesNo);
	}

//   상품 수정(upload가 비어있을 때)
	public int updateSalesEmptyUpload(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.update("salesMapper.updateSalesEmptyUpload", sales);
	}

//   찜 목록 추가
	public int likeBtn(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("salesMapper.likeBtn", sales);
	}

//   판매 상태 : 판매 중
	public int salesStatus(int salesNo, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("salesMapper.salesStatus", salesNo);
	}

//   결제 정보 체크
	public SalesDTO payCheck(int salesNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("salesMapper.payCheck", salesNo);
	}

//   판매 정보 조회
	public int selectSalesNo(int memberNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("salesMapper.selectSalesNo", memberNo);
	}

//   판매상품 회원번호 조회
	public int selectMemberNo(int salesNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("salesMapper.selectMemberNo", salesNo);
	}

//   찜 카운트 증가
	public int updateLikesCount(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.update("salesMapper.updateLikesCount", sales);
	}

//   판매 수량 업데이트
	public int updateCount(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.update("salesMapper.updateCount", sales);
	}

//   상품 판매 수 업데이트
	public int updateCompleteCount(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.update("salesMapper.updateCompleteCount", sales);
	}

//   상품 상태 업데이트
	public int salesStatusUpdate(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.update("salesMapper.salesStatusUpdate", sales);
	}

//   sales 번호 가져오기
	public int salesNoSelect(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("salesMapper.salesNoSelect");
	}

//   이미지 등록
	public int imageInsert(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("salesMapper.imageInsert", sales);
	}

//   sales 인설트
	public int salesInsert(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("salesMapper.salesInsert", sales);
	}

//   sales 삭제
	public int deleteUpdateSales(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.delete("salesMapper.deleteUpdateSales", sales);
	}

//   이미지 삭제
	public int deleteImage(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.delete("salesMapper.deleteImage", sales);
	}

//   salesStatus 삭제
	public int deleteSaleStatus(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.delete("salesMapper.deleteSaleStatus", sales);
	}

//   이미지 조회
	public List<String> ImageSelect(int salesNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("salesMapper.ImageSelect", salesNo);
	}

//   결제 완료 정보 조회   
	public int selectPayInfo(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("salesMapper.selectPayInfo", sales);
	}

}