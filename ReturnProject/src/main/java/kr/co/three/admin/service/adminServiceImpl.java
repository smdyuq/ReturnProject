package kr.co.three.admin.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.three.admin.dao.adminDAO;
import kr.co.three.admin.dto.adminDTO;

@Service
public class adminServiceImpl implements adminService {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	private adminDAO adminDao;

	// 로그인
	@Override
	public adminDTO loginAdmin(adminDTO admin) {
		return adminDao.loginAdmin(sqlSession, admin);
	}

	// 아이디 중복 검사
	@Override
	public int checkId(String id) {
		return adminDao.checkId(sqlSession, id);
	}

	// 관리자 등록
	@Override
	public int registerAdmin(adminDTO member) {
		return adminDao.registerAdmin(sqlSession, member);
	}

}