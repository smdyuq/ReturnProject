package kr.co.three.sales.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.sales.dto.SalesDTO;

@Repository
public class SalesDAO {

//	판매 등록
	public int enrollSales(SalesDTO sales, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("salesMapper.enrollSales", sales);
	}

}
