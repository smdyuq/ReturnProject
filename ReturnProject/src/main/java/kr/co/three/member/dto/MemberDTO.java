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
	private int memberType;
	private String memberImageName;
	private String memberImagePath;
	private int memberVisit;
	private String memberContent;
	private String memberOriginImageName;
	private String confirmPassword;
	private String verficationCode;
	private boolean isVerficiationCodeSent;
	private String checkCode;
	private String authenticationCode;
	
	private int cpage;
	private int ask_no;
	private String ask_comment_content;
}
