package kr.co.three.admin.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.admin.dto.adminDTO;

@Repository
public class adminDAO {

	// 로그인
	public adminDTO loginAdmin(SqlSessionTemplate sqlSession, adminDTO admin) {
		return sqlSession.selectOne("adminMapper.loginAdmin", admin);
	}

	// 아이디 중복 검사
	public int checkId(SqlSessionTemplate sqlSession, String id) {
		return sqlSession.selectOne("adminMapper.checkId", id);
	}

	// 관리자 등록
	public int registerAdmin(SqlSessionTemplate sqlSession, adminDTO member) {
		return sqlSession.insert("adminMapper.registerAdmin", member);
	}

}
