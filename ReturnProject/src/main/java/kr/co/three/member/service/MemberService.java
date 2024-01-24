package kr.co.three.member.service;

import kr.co.three.member.dto.MemberDTO;

public interface MemberService {

//	회원가입
	int registerMember(MemberDTO member);

//	아이디 중복검사
	int checkId(String memberId);

//	로그인
	MemberDTO loginMember(MemberDTO member);
}
