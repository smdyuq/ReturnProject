package kr.co.three.sales.service;

import java.io.File;
import java.io.IOException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.three.sales.dao.SalesDAO;
import kr.co.three.sales.dto.SalesDTO;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesDAO salesDAO;

	@Autowired
	private SqlSessionTemplate sqlSession;

//	판매 등록
	@Override
	public int enrollSales(SalesDTO sales) {
		return salesDAO.enrollSales(sales, sqlSession);
	}

}