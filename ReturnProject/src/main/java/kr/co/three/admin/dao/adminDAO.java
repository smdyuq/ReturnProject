package kr.co.three.admin.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.admin.dto.adminDTO;

@Repository
public class adminDAO {

	public adminDTO loginAdmin(SqlSessionTemplate sqlSession, adminDTO admin) {
		return sqlSession.selectOne("adminMapper.loginAdmin", admin);
	}

	public int checkId(SqlSessionTemplate sqlSession, String id) {
		return sqlSession.selectOne("adminMapper.checkId", id);
	}

	public int registerAdmin(SqlSessionTemplate sqlSession, adminDTO member) {
		return sqlSession.insert("adminMapper.registerAdmin", member);
	}

	
	
}
