package kr.co.three.pay.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.pay.dto.PayDTO;

@Repository
public class PayDAO {


	public PayDTO payCheck(int salesNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("payMapper.payCheck", salesNo);
	}

	public int insertPay(PayDTO pay, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("payMapper.insertPay", pay);
	}

}