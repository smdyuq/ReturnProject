package kr.co.three.pay.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.pay.dto.PayDTO;

@Repository
public class PayDAO {

//	직거래용 페이 테이블 인설트
	public int insertDirectPay(PayDTO pay, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("payMapper.insertDirectPay", pay);
	}

//	택배거래용 페이 테이블 인설트
	public int insertDeliveryPay(PayDTO pay, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("payMapper.insertDeliveryPay", pay);
	}

}