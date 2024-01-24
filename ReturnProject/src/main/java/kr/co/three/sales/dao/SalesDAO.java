package kr.co.three.sales.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.common.PageInfo;
import kr.co.three.sales.dto.SalesDTO;

@Repository
public class SalesDAO {

//	상품관리 전체 리스트 수
	public int salesSelectListCount(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("salesMapper.salesSelectListCount", sales);
	}

//	상품관리 목록 불러오기
	public List<SalesDTO> salesSelectListAll(PageInfo pi, SalesDTO sales, SqlSessionTemplate sqlSession) {
		// 현재 페이지의 게시글을 불러오기 위한 변수
		int offset = (pi.getCpage() - 1) * pi.getBoardLimit();

		// 작은 규모일 경우에만 사용하는것을 권장
		RowBounds rb = new RowBounds(offset, pi.getBoardLimit());

		return sqlSession.selectList("salesMapper.salesSelectListAll", sales, rb);
	}

//	상품 수정 폼 이동
	public SalesDTO updateSalesForm(int salesNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("salesMapper.updateSalesForm", salesNo);
	}

//	상품 수정
	public int updateSales(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.update("salesMapper.updateSales", sales);
	}

//	상품 삭제
	public int deleteSales(int salesNo, SqlSessionTemplate sqlSession) {
		return sqlSession.delete("salesMapper.deleteSales", salesNo);
	}

//	판매 등록
	public int enrollSales(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("salesMapper.enrollSales", sales);
	}

}
