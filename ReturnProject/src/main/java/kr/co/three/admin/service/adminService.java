package kr.co.three.admin.service;

import kr.co.three.admin.dto.adminDTO;

public interface adminService {

	// 로그인
	adminDTO loginAdmin(adminDTO admin);
	
	// 이메일 중복검사
	public int checkId(String id);
	
	// 회원가입
	public int registerAdmin(adminDTO admin);
}
