package kr.co.three.main.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.main.dto.MainDTO;
import kr.co.three.sales.dto.SalesDTO;

@Repository
public class MainDAO {

//	검색 페이지 검색 데이터 등록
	public int insertSearch(MainDTO main, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("mainMapper.insertSearch", main);
	}

//	검색 데이터 리스트
	public List<MainDTO> searchList(MainDTO main, SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("mainMapper.searchList", main);
	}

//	상품 리스트
	public List<SalesDTO> mainSalesList(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("salesMapper.mainSalesList", sales);
	}

}
