package kr.co.three.pay.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.three.pay.dao.PayDAO;
import kr.co.three.pay.dto.PayDTO;

@Service
public class PayServiceImpl implements PayService{
	
	@Autowired
	private PayDAO payDao;

	@Autowired
	private SqlSessionTemplate sqlSession;

	public PayDTO payCheck(int salesNo) {
		return payDao.payCheck(salesNo, sqlSession);
	}

}