package kr.co.three.main.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.three.main.dao.MainDAO;
import kr.co.three.main.dto.MainDTO;
import kr.co.three.sales.dto.SalesDTO;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainDAO mainDAO;

	@Autowired
	private SqlSessionTemplate sqlSession;

//	중복 등록 체크
	@Override
	public int SearchWordDuplicate(MainDTO main) {
		return mainDAO.SearchWordDuplicate(main, sqlSession);
	}

//	검색 페이지 검색 데이터 등록
	@Override
	public int insertSearch(MainDTO main) {
		return mainDAO.insertSearch(main, sqlSession);
	}

//	검색 데이터 리스트
	@Override
	public List<MainDTO> searchList(MainDTO main) {
		return mainDAO.searchList(main, sqlSession);
	}

//	최근 검색어 삭제
	@Override
	public int deleteSearch(int searchNo) {
		return mainDAO.deleteSearch(searchNo, sqlSession);
	}

//	상품 리스트
	@Override
	public List<SalesDTO> mainSalesList(MainDTO main) {
		return mainDAO.mainSalesList(main, sqlSession);
	}

//	<카테고리 페이지>

//	전체 카테고리
	public List<SalesDTO> all(String searchWord) {
		return mainDAO.all(sqlSession, searchWord);
	}

//	가전 카테고리
	@Override
	public List<SalesDTO> homeAppliances(String searchWord) {
		return mainDAO.homeAppliances(sqlSession, searchWord);
	}

//	의류 카테고리
	@Override
	public List<SalesDTO> clothes(String searchWord) {
		return mainDAO.clothes(sqlSession, searchWord);
	}

//	식품 카테고리
	@Override
	public List<SalesDTO> food(String searchWord) {
		return mainDAO.food(sqlSession, searchWord);
	}

//	주얼리 카테고리
	@Override
	public List<SalesDTO> jewelry(String searchWord) {
		return mainDAO.jewelry(sqlSession, searchWord);
	}

}