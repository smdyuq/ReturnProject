package kr.co.three.admin.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.three.admin.dao.adminDAO;
import kr.co.three.admin.dto.adminDTO;

@Service
public class adminServiceImpl implements adminService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private adminDAO adminDao;

	@Override
	public adminDTO loginAdmin(adminDTO admin) {
		return adminDao.loginAdmin(sqlSession, admin);
	}
	
	@Override
	public int checkId(String id) {
		return adminDao.checkId(sqlSession, id);
	}

	@Override
	public int registerAdmin(adminDTO member) {
		return adminDao.registerAdmin(sqlSession, member);
	}

	
}
