package kr.co.three.main.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.main.dto.MainDTO;
import kr.co.three.sales.dto.SalesDTO;

@Repository
public class MainDAO {

//	중복 등록 체크
	public int SearchWordDuplicate(MainDTO main, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("mainMapper.SearchWordDuplicate", main);
	}

//	검색 페이지 검색 데이터 등록
	public int insertSearch(MainDTO main, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("mainMapper.insertSearch", main);
	}

//	검색 데이터 리스트
	public List<MainDTO> searchList(MainDTO main, SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("mainMapper.searchList", main);
	}

//	최근 검색어 삭제
	public int deleteSearch(int searchNo, SqlSessionTemplate sqlSession) {
		return sqlSession.delete("mainMapper.deleteSearch", searchNo);
	}

//	상품 리스트
	public List<SalesDTO> mainSalesList(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("salesMapper.mainSalesList", sales);
	}

//	카테고리 페이지

//	가전 카테고리
	public List<SalesDTO> homeAppliances(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("salesMapper.homeAppliances");
	}

//	의류 카테고리
	public List<SalesDTO> clothes(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("salesMapper.clothes");
	}

//	향수 카테고리
	public List<SalesDTO> perfume(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("salesMapper.perfume");
	}

//	푸드 카테고리
	public List<SalesDTO> food(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("salesMapper.food");
	}

//	주얼리 카테고리
	public List<SalesDTO> jewelry(SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("salesMapper.jewelry");
	}

}