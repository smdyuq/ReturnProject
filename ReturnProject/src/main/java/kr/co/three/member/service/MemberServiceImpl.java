package kr.co.three.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.three.member.dao.MemberDAO;
import kr.co.three.member.dto.MemberDTO;

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

}
