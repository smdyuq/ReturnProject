package kr.co.three.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.three.member.dto.MemberDTO;
import kr.co.three.sales.dto.SalesDTO;

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

//	내 상점

//	멤버 테이블 데이터 조회
	public MemberDTO selectMemberData(int memberNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("memberMapper.selectMemberData", memberNo);
	}

//	상품 테이블 데이터 조회
	public List<SalesDTO> selectSalesData(int memberNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("salesMapper.selectSalesData", memberNo);
	}

}