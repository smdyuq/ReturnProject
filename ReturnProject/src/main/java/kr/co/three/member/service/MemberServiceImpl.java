package kr.co.three.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.three.member.dao.MemberDAO;
import kr.co.three.member.dto.MemberDTO;
import kr.co.three.sales.dto.SalesDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Autowired
	private MemberDAO memberDAO;

//	회원가입
	@Override
	public int registerMember(MemberDTO member) {
		return memberDAO.registerMember(member, sqlSession);
	}

//	아이디 중복검사
	@Override
	public int checkId(String memberId) {
		return memberDAO.checkId(memberId, sqlSession);
	}

//	로그인
	@Override
	public MemberDTO loginMember(MemberDTO member) {
		return memberDAO.loginMember(member, sqlSession);
	}

// 	내 상점

// 	멤버 테이블 데이터 조회
	@Override
	public MemberDTO selectMemberData(int memberNo) {
		return memberDAO.selectMemberData(memberNo, sqlSession);
	}

//	상품 테이블 데이터 조회
	@Override
	public List<SalesDTO> selectSalesData(int memberNo) {
		return memberDAO.selectSalesData(memberNo, sqlSession);
	}

//	기존 파일 이름 조회
	@Override
	public String selectFileName(int memberNo) {
		return memberDAO.selectFileName(memberNo, sqlSession);
	}

//	상점 이미지 수정
	@Override
	public int storeImageUpdate(MemberDTO member) {
		return memberDAO.storeImageUpdate(member, sqlSession);
	}

//	찜 조회
	@Override
	public List<SalesDTO> selectLikeData(int memberNo) {
		return memberDAO.selectLikeData(memberNo, sqlSession);
	}

//	로그인 멤버 정보 조회
	@Override
	public MemberDTO userCheck(int memberNo) {
		return memberDAO.userCheck(memberNo, sqlSession);
	}

//	상점 방문 수 증가
	@Override
	public int storeVisitCount(int memberNo) {
		return memberDAO.storeVisitCount(memberNo, sqlSession);
	}

//	소개글 수정
	@Override
	public int storeContentUpdate(MemberDTO member) {
		return memberDAO.storeContentUpdate(member, sqlSession);
	}

//	상품 판매수 데이터 조회
	@Override
	public int selectSalesComplete(int memberNo) {
		return memberDAO.selectSalesComplete(memberNo, sqlSession);
	}

}