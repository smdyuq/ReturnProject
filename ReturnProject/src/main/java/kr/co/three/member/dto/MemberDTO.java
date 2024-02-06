package kr.co.three.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String memberPhone;
	private String memberType;

	private String memberImageName;
	private String memberImagePath;
	private int memberVisit;
	private String memberContent;

	private String confirmPassword;
	private String verficationCode;
	private boolean isVerficiationCodeSent;
	private String checkCode;
	private String authenticationCode;
}
