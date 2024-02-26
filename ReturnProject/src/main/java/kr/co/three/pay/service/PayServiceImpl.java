package kr.co.three.pay.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.three.pay.dao.PayDAO;
import kr.co.three.pay.dto.PayDTO;

@Service
public class PayServiceImpl implements PayService {

	@Autowired
	private PayDAO payDAO;

	@Autowired
	private SqlSessionTemplate sqlSession;

//	직거래용 페이 테이블 인설트
	@Override
	public int insertDirectPay(PayDTO pay) {
		return payDAO.insertDirectPay(pay, sqlSession);
	}

//	택배거래용 페이 테이블 인설트
	@Override
	public int insertDeliveryPay(PayDTO pay) {
		return payDAO.insertDeliveryPay(pay, sqlSession);
	}

}