package kr.co.three.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.member.dto.MemberDTO;

@Repository
public class MemberDAO {

//	회원가입
	public int registerMember(MemberDTO member, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("memberMapper.registerMember", member);
	}

//	아이디 중복검사
	public int checkId(String memberId, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("memberMapper.checkId", memberId);
	}

//	로그인
	public MemberDTO loginMember(MemberDTO member, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("memberMapper.loginMember", member);
	}

}
