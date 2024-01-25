package kr.co.three.member.service;

import java.util.List;

import kr.co.three.member.dto.MemberDTO;
import kr.co.three.sales.dto.SalesDTO;

public interface MemberService {

//	회원가입
	int registerMember(MemberDTO member);

//	아이디 중복검사
	int checkId(String memberId);

//	로그인
	MemberDTO loginMember(MemberDTO member);

//	내 상점

//	멤버 테이블 데이터 조회
	MemberDTO selectMemberData(int memberNo);

//	상품 테이블 데이터 조회
	List<SalesDTO> selectSalesData(int memberNo);
}
