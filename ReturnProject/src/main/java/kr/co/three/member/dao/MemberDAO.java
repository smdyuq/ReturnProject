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

//	기존 파일 이름 조회
	public String selectFileName(int memberNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("memberMapper.selectFileName", memberNo);
	}

//	상점 이미지 수정
	public int storeImageUpdate(MemberDTO member, SqlSessionTemplate sqlSession) {
		return sqlSession.update("memberMapper.storeImageUpdate", member);
	}

//	찜 조회
	public List<SalesDTO> selectLikeData(int memberNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("salesMapper.selectLikeData", memberNo);
	}
	
//	로그인 멤버 정보 조회
	public MemberDTO userCheck(int memberNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("memberMapper.userCheck", memberNo);
	}
	
//	상점 방문 수 증가
	public int storeVisitCount(int memberNo, SqlSessionTemplate sqlSession) {
		return sqlSession.update("memberMapper.storeVisitCount", memberNo);
	}

//	소개글 수정
	public int storeContentUpdate(MemberDTO member, SqlSessionTemplate sqlSession) {
		return sqlSession.update("memberMapper.storeContentUpdate", member);
	}

}
